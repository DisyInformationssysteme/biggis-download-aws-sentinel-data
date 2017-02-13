//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.rasdaman;

import static java.text.MessageFormat.format;
import static org.apache.camel.builder.ExpressionBuilder.fileNameExpression;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// NOT_PUBLISHED
@Component
public class RasimportCommandFactory implements IRasimportCommandFactory {

  private static final String PATH_SEPARATOR = "/"; //$NON-NLS-1$

  @SuppressWarnings("nls")
  private final String COMMAND = "rasimport "
      + "--crs-uri 'http://localhost:8080/def/crs/EPSG/0/32632':'http://localhost:8080/def/crs/OGC/0/AnsiDate' "
      + "--csz 1 "
      + "--3D top "
      + "-t UShortCube:UShortSet3 "
      + "-f {0} "
      + "--coll ''{1}'' "
      + "--coverage-name ''{2}'' "
      + "--shift 0:0:{3,number,#}";

  @Value("${rasdaman.bare.collection}")
  private String bareCollection;

  @Value("${rasdaman.bare.coverage}")
  private String bareCoverage;

  @Value("${import.directory}")
  private String importDirectory;

  @Autowired
  private DateFromPathCalculator dateCalculator;

  @Override
  public void process(Exchange exchange) throws Exception {
    String fileName = importDirectory
        + PATH_SEPARATOR
        + fileNameExpression().evaluate(exchange, String.class);
    String band = extractBand(fileName);
    String collection = bareCollection + "_" + band; //$NON-NLS-1$
    String coverage = bareCoverage + "_" + band; //$NON-NLS-1$
    long ansiDate = dateCalculator.calculateAnsiDate(fileName);
    String command = format(COMMAND, fileName, collection, coverage, ansiDate);
    exchange.getIn().setBody(command);
  }

  @SuppressWarnings("nls")
  private String extractBand(String fileName) {
    int lastPathIndex = fileName.lastIndexOf(PATH_SEPARATOR) + 1;
    return fileName.substring(lastPathIndex, fileName.indexOf(".", lastPathIndex));
  }

}
