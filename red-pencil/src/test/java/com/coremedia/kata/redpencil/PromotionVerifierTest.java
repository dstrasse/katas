/**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */
package com.coremedia.kata.redpencil;

import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO[dst] javadoc
 */
public class PromotionVerifierTest {

  private Price price;

  @Before
  public void setUp() {
    price = new Price();
  }

  @Test
  public void testFivePercentReduction() throws Exception {
    Calendar thirtyDaysBefore = Calendar.getInstance();
    //thirtyDaysBefore.add(Calendar.DAY_OF_MONTH, -30);

    price.setCurrentPrice(Money.parse("EUR 90.00"));
    price.setLastPrice(Money.parse("EUR 100.00"));

    assertTrue(PromotionVerifier.isAtLeastFivePercentOff(price));
  }

  @Test
  public void testLessThanFivePercentOff() {
    // test less than 5%
    price.setCurrentPrice(Money.parse("EUR 95.01"));
    price.setLastPrice(Money.parse("EUR 100.00"));

    assertFalse(PromotionVerifier.isAtLeastFivePercentOff(price));
  }

  @Test
  public void testExactlyFivePercentOff() throws Exception {
    // test exactly 5%
    price.setCurrentPrice(Money.parse("EUR 95.00"));
    price.setLastPrice(Money.parse("EUR 100.00"));

    assertTrue(PromotionVerifier.isAtLeastFivePercentOff(price));
  }

  @Test
  public void testExactlyThirtyPercent() throws Exception {
    price.setCurrentPrice(Money.parse("EUR 70.00"));
    price.setLastPrice(Money.parse("EUR 100.00"));

    assertTrue(PromotionVerifier.isNotMoreThirtyPercentOff(price));
  }

  @Test
  public void testMoreThirtyPercent() throws Exception {
    price.setCurrentPrice(Money.parse("EUR 69.99"));
    price.setLastPrice(Money.parse("EUR 100.00"));

    assertFalse(PromotionVerifier.isNotMoreThirtyPercentOff(price));
  }

  @Test
  public void testLessThirtyPercent() throws Exception {
    price.setCurrentPrice(Money.parse("EUR 71.99"));
    price.setLastPrice(Money.parse("EUR 100.00"));

    assertTrue(PromotionVerifier.isNotMoreThirtyPercentOff(price));
  }

  @Test
  public void testLessThanThirtyDaysStable() throws Exception {
    Calendar thirtyDaysBefore = Calendar.getInstance();
    thirtyDaysBefore.add(Calendar.DAY_OF_MONTH, -25);
    price.setLastPriceChange(thirtyDaysBefore);
    assertFalse(PromotionVerifier.isMoreThirtyDaysStable(price));
  }

  @Test
  public void testExaxtlyThirtyDaysStable() throws Exception {
    Calendar thirtyDaysBefore = Calendar.getInstance();
    thirtyDaysBefore.add(Calendar.DAY_OF_MONTH, -30);
    thirtyDaysBefore.add(Calendar.SECOND, -10);
    price.setLastPriceChange(thirtyDaysBefore);
    assertTrue(PromotionVerifier.isMoreThirtyDaysStable(price));
  }

  @Test
  public void testMoreThirtyDaysStable() throws Exception {
    Calendar thirtyDaysBefore = Calendar.getInstance();
    thirtyDaysBefore.add(Calendar.DAY_OF_MONTH, -31);
    price.setLastPriceChange(thirtyDaysBefore);
    assertTrue(PromotionVerifier.isMoreThirtyDaysStable(price));
  }

  @Test
  public void testPriceIsIncreased() throws Exception {
    price.setCurrentPrice(Money.parse("EUR 69.99"));
    price.setLastPrice(Money.parse("EUR 69.98"));
    assertTrue(PromotionVerifier.isPriceIncreased(price));
  }
  @Test
  public void testPriceIsNotIncreased() throws Exception {
    price.setCurrentPrice(Money.parse("EUR 69.99"));
    price.setLastPrice(Money.parse("EUR 69.99"));
    assertFalse(PromotionVerifier.isPriceIncreased(price));
  }

}