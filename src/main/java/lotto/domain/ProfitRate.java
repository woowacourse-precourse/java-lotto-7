package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRate {
    private static final int SCALE_DIVIDE = 3;
    private static final int SCALE_RESULT = 1;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    private final double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate of(double purchaseAmount, double totalPrize) {
        BigDecimal amount = BigDecimal.valueOf(purchaseAmount);
        BigDecimal prize = BigDecimal.valueOf(totalPrize);
        BigDecimal profitRate = prize.divide(amount, SCALE_DIVIDE, RoundingMode.HALF_UP)
                .multiply(HUNDRED)
                .setScale(SCALE_RESULT, RoundingMode.HALF_UP);
        return new ProfitRate(profitRate.doubleValue());
    }

    public double getProfitRate() {
        return profitRate;
    }
}
