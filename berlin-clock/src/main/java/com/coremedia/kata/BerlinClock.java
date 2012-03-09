package com.coremedia.kata; /**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */

import org.apache.commons.validator.routines.TimeValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Unit test for {@link BerlinClock}
 */
public class BerlinClock {

  /**
   * Transforms the time into the Berlin Clock format.
   * This method returns an array with four Strings representing the lamp's state O (off), Y (yellow> and R (red).
   *
   * @param time The time to transform in the format HH:mm:ss
   * @return The time in the Berlin Clock format.
   */
  public static String[] transformTime(String time) throws ParseException {
    verifyFormat(time);

    // retrieve hours
    String[] timeComponents = time.split(":");
    int  hours = Integer.parseInt(timeComponents[0]);
    int  minutes =  Integer.parseInt(timeComponents[1]);
    int  seconds =  Integer.parseInt(timeComponents[2]);
    return new String[]{getSeconsLamp(seconds), getFiveHoursLamps(hours), getOneHourLamps(hours), getFiveMinutesLamps(minutes), getOneMinuteLamps(minutes)};
  }

  private static void verifyFormat(String time) throws ParseException {
    if (TimeValidator.getInstance().validate(time, "HH:mm:ss", Locale.forLanguageTag("de-DE")) == null && !time.equals("24:00:00")) {
      throw new IllegalArgumentException("Cannot parse time " + time);
    }
  }

  private static String getFiveHoursLamps(int hours) {
    StringBuilder result = new StringBuilder("OOOO");

    for (int i = 0; i < (hours / 5); i++) {
      result.replace(i, i + 1, "R");
    }
    return result.toString();
  }

  private static String getOneHourLamps(int hours) {
    StringBuilder result = new StringBuilder("OOOO");

    for (int i = 0; i < (hours % 5); i++) {
      result.replace(i, i + 1, "R");
    }
    return result.toString();
  }

  private static String getFiveMinutesLamps(int minutes) {
    StringBuilder result = new StringBuilder("OOOOOOOOOOO");

    for (int i = 0; i < (minutes / 5); i++) {
      if ((i + 1) % 3 == 0) {
        result.replace(i, i + 1, "R");
      } else {
        result.replace(i, i + 1, "Y");
      }
    }
    return result.toString();
  }

  private static String getOneMinuteLamps(int minutes) {
    StringBuilder result = new StringBuilder("OOOO");

    for (int i = 0; i < (minutes % 5); i++) {
      result.replace(i, i + 1, "Y");
    }
    return result.toString();
  }

  private static String getSeconsLamp(int seconds) {
    if (seconds % 2 == 0) {
      return "Y";
    }
    return "O";
  }

}
