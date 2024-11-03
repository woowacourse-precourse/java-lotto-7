package lotto.domain;

import java.math.BigDecimal;
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
        validate(payment);
        validateNegative(profit, payment);
        BigDecimal divider = BigDecimal.valueOf(payment);
        BigDecimal percentageFactor = BigDecimal.valueOf(100L);

        return profit.multiply(percentageFactor)
            .divide(divider, 1, RoundingMode.HALF_UP);
    }

    private void validate(int payment) {
        if (payment == 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액이 0원일 시 수익률을 계산할 수 없습니다.");
        }
    }

    private void validateNegative(BigDecimal profit, int payment) {
        if (payment < 0 || profit.longValue() < 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 0보다 커야 합니다.");
        }
    }
}
