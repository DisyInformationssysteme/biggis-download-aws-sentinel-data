//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.tileinfo.model;

import java.util.Map;

// NOT_PUBLISHED
public class Crs {

  private String type;
  private Map<String, String> properties;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

}
