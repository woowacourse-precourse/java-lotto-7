package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoCalculator {
  private static final int LOTTO_PRICE = 1000;

  public int calculateNumberOfTickets(BigDecimal purchaseAmount) {
    return purchaseAmount.divide(BigDecimal.valueOf(LOTTO_PRICE)).intValue();
  }

  public BigDecimal calculateProfitRate(long totalPrize, BigDecimal purchaseAmount) {
    if (purchaseAmount.compareTo(BigDecimal.ZERO) == 0) {
      return BigDecimal.ZERO;
    }
    BigDecimal profitRate = BigDecimal.valueOf(totalPrize)
        .divide(purchaseAmount, 2, RoundingMode.HALF_UP)
        .multiply(BigDecimal.valueOf(100))
        .setScale(1, RoundingMode.HALF_UP);
    return profitRate;
  }

}
