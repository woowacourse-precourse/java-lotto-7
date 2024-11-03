package lotto.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class LottoProfitCalculator {

    public BigDecimal getProfit(List<Rank> winningResults) {
        BigDecimal profit = BigDecimal.valueOf(0L);
        for (Rank result : winningResults) {
            profit = profit.add(result.getPrize());
        }
        return profit;
    }

    public BigDecimal getProfitRate(BigDecimal profit, int payment) {
        BigDecimal divider = BigDecimal.valueOf(payment);
        BigDecimal percentageFactor = BigDecimal.valueOf(100L);

        return profit.multiply(percentageFactor)
            .divide(divider, 1, RoundingMode.HALF_UP);
    }
}
