//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.tileinfo.model;

// NOT_PUBLISHED
public class Polygon extends Geometry {
  private double[][][] coordinates;

  public double[][][] getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(double[][][] coordinates) {
    this.coordinates = coordinates;
  }

}
