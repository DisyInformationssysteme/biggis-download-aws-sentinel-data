//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.download.routes;

import java.io.IOException;

import org.apache.camel.Exchange;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

// NOT_PUBLISHED
@Component
public class GetImportPathsRouteBuilder extends SpringRouteBuilder {

  @Value("${import-paths-file}")
  private Resource importPathsFile;

  @SuppressWarnings("nls")
  @Override
  public void configure() throws Exception {
    from("timer://getImportPaths?repeatCount=1&delay=500")
        .routeId("Read Import Paths")
        .process(this::loadImportPathsFile)
        .streamCaching()
        .split(bodyAs(String.class).tokenize("\n"))
        .to(LoadContentRouteBuilder.ROUTE_LOAD_DIRECTORY);
  }

  public Exchange loadImportPathsFile(Exchange exchange) throws IOException {
    exchange.getIn().setBody(importPathsFile.getInputStream());
    return exchange;
  }
}
