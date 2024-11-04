package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRate {
    private static final int SCALE = 1;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    private final double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate of(double purchaseAmount, double totalPrize) {
        return new ProfitRate(calculateProfitRate(purchaseAmount, totalPrize));
    }

    private static double calculateProfitRate(double purchaseAmount, double totalPrize) {
        BigDecimal amount = BigDecimal.valueOf(purchaseAmount);
        BigDecimal prize = BigDecimal.valueOf(totalPrize);
        BigDecimal profitRate = prize.multiply(HUNDRED)
                .divide(amount, SCALE, RoundingMode.HALF_UP);
        return profitRate.doubleValue();
    }

    public double getProfitRate() {
        return profitRate;
    }
}
