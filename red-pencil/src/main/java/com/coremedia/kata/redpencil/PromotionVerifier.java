/**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */
package com.coremedia.kata.redpencil;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * TODO[dst] javadoc
 */
public class PromotionVerifier {

  public static boolean isPromotionPrice(Price price) {

    return false;
  }

  public static boolean isAtLeastFivePercentOff(Price price) {
    BigDecimal divide = price.getCurrentPrice().getAmount().divide(price.getLastPrice().getAmount());


    return divide.compareTo(new BigDecimal("0.95")) <= 0;
  }

  public static boolean isNotMoreThirtyPercentOff(Price price) {
    BigDecimal divide = price.getCurrentPrice().getAmount().divide(price.getLastPrice().getAmount());


    return divide.compareTo(new BigDecimal("0.70")) >= 0;
  }

  public static boolean isMoreThirtyDaysStable(Price price) {
    Calendar thirtyDaysBefore = Calendar.getInstance();
    thirtyDaysBefore.add(Calendar.DAY_OF_MONTH, -30);
    Calendar lastChange = price.getLastPriceChange();

    return lastChange.before(thirtyDaysBefore);
  }

  public static boolean isDurationExceeded(Price price) {
    return false;
  }

  public static boolean isPriceIncreased(Price price) {
    return price.getCurrentPrice().isGreaterThan(price.getLastPrice());
  }

}
