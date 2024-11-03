package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.constant.Constant;

public class ProfitRate {
    private final double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate of(double purchaseAmount, double totalPrize) {
        BigDecimal amount = new BigDecimal(String.valueOf(purchaseAmount));
        BigDecimal prize = new BigDecimal(String.valueOf(totalPrize));
        BigDecimal profitRate = prize.divide(amount, Constant.SCALE_DIVIDE, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100.0"))
                .setScale(Constant.SCALE_RESULT, RoundingMode.HALF_UP);
        return new ProfitRate(profitRate.doubleValue());
    }

    public double getProfitRate() {
        return profitRate;
    }
}
