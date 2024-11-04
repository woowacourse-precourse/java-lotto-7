package lotto.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtil {
    public static final BigDecimal PERCENTAGE_MULTIPLIER = BigDecimal.valueOf(100);
    public static final int DIVISION_SCALE = 10;

    private BigDecimalUtil(){}

    public static BigDecimal divideAndMultiplyByPercentage(BigDecimal totalPrize, BigDecimal totalSpent) {
        return totalPrize
                .divide(totalSpent, DIVISION_SCALE, RoundingMode.HALF_UP)
                .multiply(PERCENTAGE_MULTIPLIER);
    }

    public static double roundToDecimalPlaces(BigDecimal value, int scale) {
        return value.setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
}