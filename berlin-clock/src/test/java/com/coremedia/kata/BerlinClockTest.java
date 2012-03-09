/**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */
package com.coremedia.kata;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertArrayEquals;

/**
 * The Berlin Clock.
 * http://content.codersdojo.org/code-kata-catalogue/berlin-clock/
 * http://de.wikipedia.org/wiki/Berlin-Uhr
 */
public class BerlinClockTest {

  @Test
  public void testMidnight() throws Exception {
    String[] result = BerlinClock.transformTime("00:00:00");
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, result);
  }

  @Test
  public void testHours() throws Exception {
    // modnight
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:00"));
    // one o'clock
    assertArrayEquals(new String[]{"Y", "OOOO", "ROOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("01:00:00"));
    // two o'clock
    assertArrayEquals(new String[]{"Y", "OOOO", "RROO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("02:00:00"));
    // three o'clock
    assertArrayEquals(new String[]{"Y", "OOOO", "RRRO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("03:00:00"));
    // four o'clock
    assertArrayEquals(new String[]{"Y", "OOOO", "RRRR", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("04:00:00"));
    // five o'clock
    assertArrayEquals(new String[]{"Y", "ROOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("05:00:00"));
    // six o'clock
    assertArrayEquals(new String[]{"Y", "ROOO", "ROOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("06:00:00"));
    // seven o'clock
    assertArrayEquals(new String[]{"Y", "ROOO", "RROO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("07:00:00"));
    // eight o'clock
    assertArrayEquals(new String[]{"Y", "ROOO", "RRRO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("08:00:00"));
    // nine o'clock
    assertArrayEquals(new String[]{"Y", "ROOO", "RRRR", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("09:00:00"));
    // ten o'clock
    assertArrayEquals(new String[]{"Y", "RROO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("10:00:00"));
    // eleven o'clock
    assertArrayEquals(new String[]{"Y", "RROO", "ROOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("11:00:00"));
    // twelve o'clock
    assertArrayEquals(new String[]{"Y", "RROO", "RROO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("12:00:00"));
    // thirteen o'clock
    assertArrayEquals(new String[]{"Y", "RROO", "RRRO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("13:00:00"));
    // fourteen o'clock
    assertArrayEquals(new String[]{"Y", "RROO", "RRRR", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("14:00:00"));
    // fifteen o'clock
    assertArrayEquals(new String[]{"Y", "RRRO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("15:00:00"));
    // sixteen o'clock
    assertArrayEquals(new String[]{"Y", "RRRO", "ROOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("16:00:00"));
    // seventeen o'clock
    assertArrayEquals(new String[]{"Y", "RRRO", "RROO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("17:00:00"));
    // eighteen o'clock
    assertArrayEquals(new String[]{"Y", "RRRO", "RRRO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("18:00:00"));
    // nineteen o'clock
    assertArrayEquals(new String[]{"Y", "RRRO", "RRRR", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("19:00:00"));
    // twenty o'clock
    assertArrayEquals(new String[]{"Y", "RRRR", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("20:00:00"));
    // twenty-one o'clock
    assertArrayEquals(new String[]{"Y", "RRRR", "ROOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("21:00:00"));
    // twenty-two o'clock
    assertArrayEquals(new String[]{"Y", "RRRR", "RROO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("22:00:00"));
    // twenty-three o'clock
    assertArrayEquals(new String[]{"Y", "RRRR", "RRRO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("23:00:00"));
    // twenty-four o'clock
    assertArrayEquals(new String[]{"Y", "RRRR", "RRRR", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("24:00:00"));
  }

  @Test
  public void testMinutes() throws Exception {
    // zero minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:00"));
    // one minute
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "YOOO"}, BerlinClock.transformTime("00:01:00"));
    // two minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "YYOO"}, BerlinClock.transformTime("00:02:00"));
    // three minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "YYYO"}, BerlinClock.transformTime("00:03:00"));
    // four minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "YYYY"}, BerlinClock.transformTime("00:04:00"));
    // three minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:05:00"));

    // fourteen minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYOOOOOOOOO", "YYYY"}, BerlinClock.transformTime("00:14:00"));
    // fifteen minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYROOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:15:00"));
    // sixteen minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYROOOOOOOO", "YOOO"}, BerlinClock.transformTime("00:16:00"));

    // nineteen minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYROOOOOOOO", "YYYY"}, BerlinClock.transformTime("00:19:00"));
    // twenty minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:20:00"));
    // twenty-one minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYOOOOOOO", "YOOO"}, BerlinClock.transformTime("00:21:00"));

    // twenty-five minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYYOOOOOO", "OOOO"}, BerlinClock.transformTime("00:25:00"));

    // thirty minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYYROOOOO", "OOOO"}, BerlinClock.transformTime("00:30:00"));

    // thirty-five minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYYRYOOOO", "OOOO"}, BerlinClock.transformTime("00:35:00"));

    // forty minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYYRYYOOO", "OOOO"}, BerlinClock.transformTime("00:40:00"));

    // forty-five minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYYRYYROO", "OOOO"}, BerlinClock.transformTime("00:45:00"));

    // fifty minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYYRYYRYO", "OOOO"}, BerlinClock.transformTime("00:50:00"));

    // fifty-five minutes
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "YYRYYRYYRYY", "OOOO"}, BerlinClock.transformTime("00:55:00"));
  }

  @Test
  public void testSeconds() throws Exception {
    // even seconds
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:00"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:02"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:04"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:06"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:08"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:10"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:20"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:30"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:40"));
    assertArrayEquals(new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:50"));


    // uneven seconds
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:01"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:03"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:05"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:07"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:09"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:11"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:21"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:31"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:41"));
    assertArrayEquals(new String[]{"O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("00:00:51"));
  }

  @Test
  public void testSomeTimes() throws Exception {
    // 16:36:35
    assertArrayEquals(new String[]{"O", "RRRO", "ROOO", "YYRYYRYOOOO", "YOOO"}, BerlinClock.transformTime("16:36:35"));
    // 16:36:36
    assertArrayEquals(new String[]{"Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YOOO"}, BerlinClock.transformTime("16:36:36"));
    // 21:45:15
    assertArrayEquals(new String[]{"O", "RRRR", "ROOO", "YYRYYRYYROO", "OOOO"}, BerlinClock.transformTime("21:45:15"));
    // 24:00:00
    assertArrayEquals(new String[]{"Y", "RRRR", "RRRR", "OOOOOOOOOOO", "OOOO"}, BerlinClock.transformTime("24:00:00"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTimeFormat1() throws Exception {
    BerlinClock.transformTime("12:33");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTimeFormat2() throws Exception {
    BerlinClock.transformTime("abc");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTimeFormat3() throws Exception {
    BerlinClock.transformTime("25:00:00");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTimeFormat4() throws Exception {
    BerlinClock.transformTime("12:61:00");
  }
}