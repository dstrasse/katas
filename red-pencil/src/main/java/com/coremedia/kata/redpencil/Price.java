/**
 * Copyright (c) 2012 CoreMedia AG, Hamburg. All rights reserved.
 */
package com.coremedia.kata.redpencil;

import org.joda.money.Money;

import java.util.Calendar;

/**
 * TODO[dst] javadoc
 */
public class Price {

  private Money currentPrice;
  private Money lastPrice;
  private Money basePrice;
  private Calendar lastPriceChange;
  private Calendar promotionStart;
  private Calendar lastPromotionEnd;
  private boolean isInPromotion;

  public Calendar getLastPromotionEnd() {
    return lastPromotionEnd;
  }

  public void setLastPromotionEnd(Calendar lastPromotionEnd) {
    this.lastPromotionEnd = lastPromotionEnd;
  }

  public Calendar getPromotionStart() {
    return promotionStart;
  }

  public void setPromotionStart(Calendar promotionStart) {
    this.promotionStart = promotionStart;
  }

  public boolean isInPromotion() {
    return isInPromotion;
  }

  public void setInPromotion(boolean inPromotion) {
    isInPromotion = inPromotion;
  }

  public Money getCurrentPrice() {
    return currentPrice;
  }

  public void setCurrentPrice(Money currentPrice) {
    this.currentPrice = currentPrice;
  }

  public Money getLastPrice() {
    return lastPrice;
  }

  public void setLastPrice(Money lastPrice) {
    this.lastPrice = lastPrice;
  }

  public Calendar getLastPriceChange() {
    return lastPriceChange;
  }

  public void setLastPriceChange(Calendar lastPriceChange) {
    this.lastPriceChange = lastPriceChange;
  }

  public Money getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Money basePrice) {
    this.basePrice = basePrice;
  }

}
