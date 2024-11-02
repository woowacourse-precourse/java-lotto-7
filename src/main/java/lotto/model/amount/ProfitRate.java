package lotto.model.amount;

import java.math.BigDecimal;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 2.
 */
public class ProfitRate {
  private BigDecimal rate;

  private ProfitRate (BigDecimal rate) {
    this.rate = rate;
  }

  public static ProfitRate from(BigDecimal rate) {
    return new ProfitRate(rate);
  }

  public BigDecimal getRate() {
    return this.rate;
  }
}
