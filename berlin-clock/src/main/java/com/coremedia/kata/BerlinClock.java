package com.coremedia.kata; /**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    String hours = time.substring(0, time.indexOf(':'));
    String minutes = time.substring(time.indexOf(':') + 1, time.lastIndexOf(':'));
    String seconds = time.substring(time.lastIndexOf(':') + 1);
    return new String[]{getSeconsLamp(seconds), getFiveHoursLamps(hours), getOneHourLamps(hours), getFiveMinutesLamps(minutes), getOneMinuteLamps(minutes)};
  }

  private static void verifyFormat(String time) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    sdf.parse(time);
  }

  private static String getFiveHoursLamps(String hoursString) {
    StringBuilder result = new StringBuilder("OOOO");
    int hours = Integer.parseInt(hoursString);

    for (int i = 0; i < (hours / 5); i++) {
      result.replace(i, i + 1, "R");
    }
    return result.toString();
  }

  private static String getOneHourLamps(String hoursString) {
    StringBuilder result = new StringBuilder("OOOO");
    int hours = Integer.parseInt(hoursString);

    for (int i = 0; i < (hours % 5); i++) {
      result.replace(i, i + 1, "R");
    }
    return result.toString();
  }

  private static String getFiveMinutesLamps(String minutesString) {
    StringBuilder result = new StringBuilder("OOOOOOOOOOO");
    int minutes = Integer.parseInt(minutesString);

    for (int i = 0; i < (minutes / 5); i++) {
      if ((i + 1) % 3 == 0) {
        result.replace(i, i + 1, "R");
      } else {
        result.replace(i, i + 1, "Y");
      }
    }
    return result.toString();
  }

  private static String getOneMinuteLamps(String minutesString) {
    StringBuilder result = new StringBuilder("OOOO");
    int minutes = Integer.parseInt(minutesString);

    for (int i = 0; i < (minutes % 5); i++) {
      result.replace(i, i + 1, "Y");
    }
    return result.toString();
  }

  private static String getSeconsLamp(String secondsAsString) {
    int seconds = Integer.parseInt(secondsAsString);
    if (seconds % 2 == 0) {
      return "Y";
    }
    return "O";
  }

}
