//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.download.filter;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// NOT_PUBLISHED
@Component
public class SkipPresentFilePredicate {

  @Value("${skip.existing.files}")
  boolean isSkipExistingFiles;

  @Value("${import.directory}")
  private String importDirectory;

  public boolean isSkip(@Header(Exchange.FILE_NAME) String fileName) {
    File file = new File(importDirectory + File.separator + fileName);
    return isSkipExistingFiles && file.exists();
  }

}
