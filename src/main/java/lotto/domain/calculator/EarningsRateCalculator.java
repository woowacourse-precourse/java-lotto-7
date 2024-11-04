package lotto.domain.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static lotto.constants.LottoConstants.PERCENT;
import static lotto.constants.LottoConstants.PLACE_TO_ROUND_TO;

public class EarningsRateCalculator {
    private final BigDecimal purchaseAmount;
    private final BigDecimal winningAmount;
    private BigDecimal earningsRate;

    public EarningsRateCalculator(BigDecimal purchaseAmount, BigDecimal winningAmount) {
        this.purchaseAmount = purchaseAmount;
        this.winningAmount = winningAmount;
        calculateEarningsRate();
    }

    private void calculateEarningsRate() {
        BigDecimal winningAmountMultiplyPercent = winningAmount.multiply(BigDecimal.valueOf(PERCENT));
        this.earningsRate = winningAmountMultiplyPercent.divide(purchaseAmount, PLACE_TO_ROUND_TO, RoundingMode.HALF_UP);
    }

    public String getEarningsRate() {
        return this.earningsRate.toPlainString();
    }
}
