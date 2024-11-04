package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Prize;

public class ProfitCalculate {

    public static BigDecimal calculateWinningAmount(final Map<Prize, Integer> prizeCounts) {
        BigDecimal winningAmount = BigDecimal.ZERO;

        for (Entry<Prize, Integer> entry : prizeCounts.entrySet()) {
            BigDecimal prizeAmount = BigDecimal.valueOf(entry.getKey().getPrizeAmount());
            winningAmount = winningAmount.add(
                prizeAmount.multiply(BigDecimal.valueOf(entry.getValue())));
        }

        return winningAmount;
    }

    public static BigDecimal calculateProfit(final int purchasePrice,
        final Map<Prize, Integer> prizeCounts) {
        BigDecimal winningAmount = calculateWinningAmount(prizeCounts);
        BigDecimal profit = winningAmount.divide(BigDecimal.valueOf(purchasePrice), 2,
            RoundingMode.HALF_UP);
        return profit.setScale(1, RoundingMode.HALF_UP);
    }
}
