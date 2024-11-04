package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.exception.LottoExceptionMessage;

public class LottoProfitCalculator {

    public BigDecimal getProfit(List<Rank> winningResults) {
        BigDecimal profit = BigDecimal.valueOf(0L);
        for (Rank result : winningResults) {
            profit = profit.add(result.getPrize());
        }
        return profit;
    }

    public BigDecimal getProfitRate(BigDecimal profit, int payment) {
        validate(payment);
        validateNegative(profit, payment);
        BigDecimal divider = BigDecimal.valueOf(payment);
        BigDecimal percentageFactor = BigDecimal.valueOf(100L);

        return profit.multiply(percentageFactor)
            .divide(divider, 1, RoundingMode.HALF_UP)
            .stripTrailingZeros();
    }

    private void validate(int payment) {
        if (payment == 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.PROFIT_WITH_ZERO_AMOUNT);
        }
    }

    private void validateNegative(BigDecimal profit, int payment) {
        if (payment < 0 || profit.longValue() < 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.NATURAL_NUMBER_PAYMENT);
        }
    }
}
