//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.download.routes;

import static org.apache.camel.util.toolbox.AggregationStrategies.useOriginal;

import java.util.concurrent.Executors;

import net.disy.biggis.sentinel.download.aws.model.CommonPrefixesType;
import net.disy.biggis.sentinel.download.aws.model.ContentsType;
import net.disy.biggis.sentinel.download.aws.model.ListBucketResultType;
import net.disy.biggis.sentinel.download.filter.SkipPresentFilePredicate;
import net.disy.biggis.sentinel.rasdaman.IRasimportCommandFactory;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// NOT_PUBLISHED
@SuppressWarnings("nls")
@Component
public class LoadContentRouteBuilder extends SpringRouteBuilder {

  static final String ROUTE_LOAD_DIRECTORY = "seda:loadDirectory?concurrentConsumers=3";
  static final String ROUTE_LOAD_FILE = "direct:loadFile";
  static final String ROUTE_IMPORT_TO_RASDAMAN = "seda:importRasdaman";

  @Value("${bucket.endpoint}")
  private String awsEndpointUrl;

  @Value("${import.directory}")
  private String importDirectory;

  @Autowired
  private IRasimportCommandFactory rasimportCommandFactory;

  @Autowired
  private SkipPresentFilePredicate skipPresentFiles;

  @Override
  public void configure() throws Exception {
    from(ROUTE_LOAD_DIRECTORY)
        .routeId("Load Directory")
        .log("${body}")
        .process(LoadContentRouteBuilder::prepareListBucketRequest)
        .to(awsEndpointUrl)
        .unmarshal()
        .jaxb(ListBucketResultType.class.getPackage().getName())
        .process(LoadContentRouteBuilder::recursiveListBucket)
        .transform(simple("${body.contents}"))
        .split(simple("${body}"), useOriginal())
        .streaming()
        .executorService(Executors.newFixedThreadPool(5))
        .to(ROUTE_LOAD_FILE);
    from(ROUTE_LOAD_FILE)
        .routeId("Load File")
        .onException(Exception.class)
        .log(LoggingLevel.ERROR, "Error loading ${header.CamelHttpPath}")
        .maximumRedeliveries(5)
        .redeliveryDelay(5000)
        .end()
        .process(LoadContentRouteBuilder::prepareFileRequest)
        .choice()
        .when()
        .method(skipPresentFiles, "isSkip")
        .log("skipping: ${header.CamelFileName}")
        .stop()
        .otherwise()
        .log("loading: ${header.CamelHttpPath}")
        .to(awsEndpointUrl)
        .log("writing: ${header.CamelFileName}")
        .to("file:" + importDirectory)
        .choice()
        .when(header(Exchange.FILE_NAME).endsWith(".jp2"))
        .to(ROUTE_IMPORT_TO_RASDAMAN)
        .otherwise()
        .log("finished on: ${header.CamelFileName}")
        .end()
        .end();
    from(ROUTE_IMPORT_TO_RASDAMAN)
        .routeId("Rasdaman Command")
        .process(rasimportCommandFactory)
        .log("${body}");
  }

  private static void prepareListBucketRequest(Exchange exchange) {
    exchange.setPattern(ExchangePattern.InOut);
    Message in = exchange.getIn();
    String query = "delimiter=%2F&prefix=" + in.getBody(String.class).trim().replace("/", "%2F");
    in.setHeader(Exchange.HTTP_QUERY, query);
    in.setBody(null);
  }

  private static void recursiveListBucket(Exchange exchange) {
    ListBucketResultType result = exchange.getIn().getBody(ListBucketResultType.class);
    ProducerTemplate producer = exchange.getContext().createProducerTemplate();
    result
        .getCommonPrefixes()
        .stream()
        .map(CommonPrefixesType::getPrefix)
        .forEach(prefix -> producer.sendBody(ROUTE_LOAD_DIRECTORY, prefix));
  }

  private static void prepareFileRequest(Exchange exchange) {
    exchange.setPattern(ExchangePattern.InOut);
    Message in = exchange.getIn();
    String query = in.getBody(ContentsType.class).getKey();
    in.setHeader(Exchange.HTTP_PATH, query);
    in.setHeader(Exchange.FILE_NAME, query);
    in.setBody(null);
  }
}
