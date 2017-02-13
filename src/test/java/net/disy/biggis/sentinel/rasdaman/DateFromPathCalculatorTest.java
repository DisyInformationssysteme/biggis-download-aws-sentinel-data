package net.disy.biggis.sentinel.rasdaman;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateFromPathCalculatorTest {

  private long expectedAnsiDate;
  private String filename;

  @SuppressWarnings("nls")
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        { 150118L, "tiles/32/U/NV/2012/01/04/0/B06.jp2" },
        { 151845L, "tiles/32/U/QB/2016/9/26/0/preview/B03.jp2" } });
  }

  public DateFromPathCalculatorTest(long expectedAnsiDate, String filename) {
    this.expectedAnsiDate = expectedAnsiDate;
    this.filename = filename;
  }

  @Test
  public void correctAnsiDate() throws Exception {
    long calculatedAnsiDate = new DateFromPathCalculator().calculateAnsiDate(filename);
    assertThat(calculatedAnsiDate, is(expectedAnsiDate));
  }
}
