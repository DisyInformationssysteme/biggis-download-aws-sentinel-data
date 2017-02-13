//Copyright (c) 2016 by Disy Informationssysteme GmbH
package net.disy.biggis.sentinel.rasdaman;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

// NOT_PUBLISHED
@Component
public class DateFromPathCalculator {

  private static final String PATH_TILES_DIRECTORY = "tiles"; //$NON-NLS-1$
  private static final String PATH_SEPARATOR = "/"; //$NON-NLS-1$

  private static final int INDEX_YEAR = 4;
  private static final int INDEX_MONTH = 5;
  private static final int INDEX_DAY = 6;

  private static final LocalDate ANSI_START = Year.of(1601).atDay(1);

  public long calculateAnsiDate(String fileName) {
    String[] parts = fileName.split(PATH_SEPARATOR);
    int tilesIndex = IntStream
        .range(0, parts.length)
        .filter(i -> parts[i].equals(PATH_TILES_DIRECTORY))
        .findFirst()
        .orElse(0);
    LocalDate date = Year
        .of(parse(parts, tilesIndex + INDEX_YEAR))
        .atMonth(parse(parts, tilesIndex + INDEX_MONTH))
        .atDay(parse(parts, tilesIndex + INDEX_DAY));
    return ChronoUnit.DAYS.between(ANSI_START, date) + 1;
  }

  private int parse(String[] parts, int index) {
    return Integer.parseInt(parts[index]);
  }

}
