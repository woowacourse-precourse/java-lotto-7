package lotto.mvc.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.EnumMap;

public class LottoReturnCalculator {
    private static final int ROUND_DECIMAL_POINT = 3;
    private static final int PERCENTAGE = 100;

    public static BigDecimal calculateTotalReturn(EnumMap<LottoWinningAmount, Integer> winningCounts,
                                                  long purchaseAmount) {
        BigInteger totalAmount = calculateTotalWinningAmount(winningCounts);
        return new BigDecimal(totalAmount)
                .divide(BigDecimal.valueOf(purchaseAmount), ROUND_DECIMAL_POINT, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(PERCENTAGE));
    }

    private static BigInteger calculateTotalWinningAmount(EnumMap<LottoWinningAmount, Integer> winningCounts) {
        BigInteger totalAmount = BigInteger.ZERO;

        for (EnumMap.Entry<LottoWinningAmount, Integer> prize : winningCounts.entrySet()) {
            LottoWinningAmount winningAmount = prize.getKey();
            int count = prize.getValue();

            totalAmount = totalAmount.add(winningAmount.calculatePrize(count));
        }

        return totalAmount;
    }
}
