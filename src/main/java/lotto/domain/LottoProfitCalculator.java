package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.exception.LottoExceptionMessage;

public class LottoProfitCalculator {

    private static final Long PERCENTAGE_FACTOR = 100L;
    private static final int DECIMAL_PLACES = 1;

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
        BigDecimal percentageFactor = BigDecimal.valueOf(PERCENTAGE_FACTOR);

        return profit.multiply(percentageFactor)
            .divide(divider, DECIMAL_PLACES, RoundingMode.HALF_UP)
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
