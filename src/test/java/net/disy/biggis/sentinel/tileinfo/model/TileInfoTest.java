package net.disy.biggis.sentinel.tileinfo.model;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.time.Year;
import java.time.ZoneId;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SuppressWarnings("nls")
public class TileInfoTest {

  private InputStream sample = TileInfoTest.class.getResourceAsStream("tileInfo.json");

  @Test
  public void readsSampleCorrectly() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    ObjectReader reader = mapper.readerFor(TileInfo.class);

    TileInfo tileInfo = reader.readValue(sample);
    Polygon tileGeometry = tileInfo.getTileGeometry();

    assertThat(tileInfo.getPath(), is("tiles/32/U/LA/2016/9/12/0"));
    assertThat(tileInfo.getUtmZone(), is(32));
    assertThat(tileInfo.getLatitudeBand(), is("U"));
    assertThat(tileInfo.getGridSquare(), is("LA"));
    assertThat(
        tileInfo.getTimestamp(),
        is(Year
            .of(2016)
            .atMonth(9)
            .atDay(12)
            .atTime(10, 35, 51, 370000000)
            .atZone(ZoneId.of("UTC"))));

    assertThat(tileGeometry.getType(), is("Polygon"));
    assertThat(
        tileGeometry.getCrs().getProperties(),
        hasEntry("name", "urn:ogc:def:crs:EPSG:8.8.1:32632"));
  }
}
