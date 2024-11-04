package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRate {
    private static final int SCALE_DIVIDE = 3;
    private static final int SCALE_RESULT = 1;
    private static final double HUNDRED = 100.0;

    private final double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate of(double purchaseAmount, double totalPrize) {
        BigDecimal amount = new BigDecimal(String.valueOf(purchaseAmount));
        BigDecimal prize = new BigDecimal(String.valueOf(totalPrize));
        BigDecimal profitRate = prize.divide(amount, SCALE_DIVIDE, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(String.valueOf(HUNDRED)))
                .setScale(SCALE_RESULT, RoundingMode.HALF_UP);
        return new ProfitRate(profitRate.doubleValue());
    }

    public double getProfitRate() {
        return profitRate;
    }
}
