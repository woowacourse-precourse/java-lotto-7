package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoProfitCalculator {

    public BigDecimal calculateProfit(List<Rank> winningResults) {
        BigDecimal profit = BigDecimal.valueOf(0L);
        for (Rank result : winningResults) {
            profit = profit.add(result.getPrize());
        }
        return profit;
    }
}
