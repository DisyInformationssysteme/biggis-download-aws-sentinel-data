//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.tileinfo.model;

// NOT_PUBLISHED
public class Point extends Geometry {

  private double[] coordinates;

  public synchronized double[] getCoordinates() {
    return coordinates;
  }

  public synchronized void setCoordinates(double[] coordinates) {
    this.coordinates = coordinates;
  }

}
