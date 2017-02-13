//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.tileinfo.model;

import java.time.ZonedDateTime;

// NOT_PUBLISHED
public class TileInfo {

  private String path;
  private ZonedDateTime timestamp;
  private int utmZone;
  private String latitudeBand;
  private String gridSquare;
  private Datastrip datastrip;
  private Polygon tileGeometry;
  private Polygon tileDataGeometry;
  private Point tileOrigin;
  private double dataCoveragePercentage;
  private double cloudyPixelPercentage;
  private String productName;
  private String productPath;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public int getUtmZone() {
    return utmZone;
  }

  public void setUtmZone(int utmZone) {
    this.utmZone = utmZone;
  }

  public String getLatitudeBand() {
    return latitudeBand;
  }

  public void setLatitudeBand(String latitudeBand) {
    this.latitudeBand = latitudeBand;
  }

  public String getGridSquare() {
    return gridSquare;
  }

  public void setGridSquare(String gridSquare) {
    this.gridSquare = gridSquare;
  }

  public Datastrip getDatastrip() {
    return datastrip;
  }

  public void setDatastrip(Datastrip datastrip) {
    this.datastrip = datastrip;
  }

  public Polygon getTileGeometry() {
    return tileGeometry;
  }

  public void setTileGeometry(Polygon tileGeometry) {
    this.tileGeometry = tileGeometry;
  }

  public Polygon getTileDataGeometry() {
    return tileDataGeometry;
  }

  public void setTileDataGeometry(Polygon tileDataGeometry) {
    this.tileDataGeometry = tileDataGeometry;
  }

  public Point getTileOrigin() {
    return tileOrigin;
  }

  public void setTileOrigin(Point tileOrigin) {
    this.tileOrigin = tileOrigin;
  }

  public double getDataCoveragePercentage() {
    return dataCoveragePercentage;
  }

  public void setDataCoveragePercentage(double dataCoveragePercentage) {
    this.dataCoveragePercentage = dataCoveragePercentage;
  }

  public double getCloudyPixelPercentage() {
    return cloudyPixelPercentage;
  }

  public void setCloudyPixelPercentage(double cloudyPixelPercentage) {
    this.cloudyPixelPercentage = cloudyPixelPercentage;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductPath() {
    return productPath;
  }

  public void setProductPath(String productPath) {
    this.productPath = productPath;
  }

}
