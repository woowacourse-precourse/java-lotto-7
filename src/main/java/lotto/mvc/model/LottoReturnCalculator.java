package lotto.mvc.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class LottoReturnCalculator {

    public static BigDecimal calculateTotalReturn(EnumMap<LottoWinningAmount, Integer> winningCounts,
                                                  long purchaseAmount) {
        BigInteger totalAmount = calculateTotalWinningAmount(winningCounts);
        return new BigDecimal(totalAmount)
                .divide(BigDecimal.valueOf(purchaseAmount), 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }

    private static BigInteger calculateTotalWinningAmount(Map<LottoWinningAmount, Integer> winningCounts) {
        BigInteger totalAmount = BigInteger.ZERO;

        for (Map.Entry<LottoWinningAmount, Integer> entry : winningCounts.entrySet()) {
            LottoWinningAmount winningAmount = entry.getKey();
            int count = entry.getValue();

            totalAmount = totalAmount.add(winningAmount.calculatePrize(count));
        }

        return totalAmount;
    }
}
