package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.util.LottoConstants;

public class LottoCalculator {
  public int calculateNumberOfTickets(BigDecimal purchaseAmount) {
    return purchaseAmount.divide(LottoConstants.LOTTO_PRICE, RoundingMode.DOWN).intValue();
  }

  public BigDecimal calculateProfitRate(long totalPrize, BigDecimal purchaseAmount) {
    if (purchaseAmount.compareTo(BigDecimal.ZERO) == 0) {
      return BigDecimal.ZERO;
    }
    return BigDecimal.valueOf(totalPrize)
        .multiply(BigDecimal.valueOf(100))
        .divide(purchaseAmount, 1, RoundingMode.HALF_UP);
  }

}
