//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel;

import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import net.disy.biggis.sentinel.download.aws.model.ListBucketResultType;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

// NOT_PUBLISHED
@SuppressWarnings("nls")
public class LearningTest extends CamelTestSupport {

  @Produce(uri = "direct:start")
  private ProducerTemplate start;

  @EndpointInject(uri = "mock:target")
  private MockEndpoint target;

  @Override
  protected RoutesBuilder createRouteBuilder() throws Exception {
    return new RouteBuilder() {

      @Override
      public void configure() throws Exception {
        getContext().setTracing(true);
        from("direct:start")
        //            .choice()
        //            .when()
        //            .xpath("boolean(/ListBucketResult/Contents)")
            .unmarshal()
            .jaxb(ListBucketResultType.class.getPackage().getName())
            .log("${body}")
            .to("mock:target");
      }
    };
  }

  @Test
  public void testname() throws Exception {
    try (InputStream input = getClass().getResourceAsStream("bucket-content-sample.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
      String sample = reader.lines().collect(Collectors.joining("\n"));
      start.sendBody(sample);
    }
    target.getExchanges().stream().map(Exchange::getIn).forEach(b -> System.out.println(b));

  }

  @Test
  public void extractBand() throws Exception {
    String fileName = "tiles/32/U/NV/2016/9/12/0/B06.jp2";
    int lastPathIndex = fileName.lastIndexOf("/") + 1;
    String band = fileName.substring(lastPathIndex, fileName.indexOf(".", lastPathIndex));

    assertThat(band, is("B06"));
  }

  @Test
  public void extractDate() throws Exception {
    String fileName = "tiles/32/U/NV/2012/01/04/0/B06.jp2";
    String[] parts = fileName.split("/");
    LocalDate date = Year
        .of(parse(parts, parts.length - 5))
        .atMonth(parse(parts, parts.length - 4))
        .atDay(parse(parts, parts.length - 3));
    long ansiDate = ChronoUnit.DAYS.between(Year.of(1601).atDay(1), date) + 1;
    assertThat(ansiDate, is(150118L));
  }

  private int parse(String[] parts, int index) {
    return Integer.parseInt(parts[index]);
  }

}
