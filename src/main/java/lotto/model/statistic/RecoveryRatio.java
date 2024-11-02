package lotto.model.statistic;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class RecoveryRatio {

    private static final DecimalFormat formatter = new DecimalFormat("#,##0.0'%'");
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
    private static final int DECIMAL_POINT_POLICY = 1;
    private static final int MAX_DECIMAL_POINT_POLICY = 10;

    private final BigDecimal value;

    private RecoveryRatio(final BigDecimal value) {
        this.value = value;
    }

    public static RecoveryRatio from(BigDecimal value) {
        return new RecoveryRatio(value);
    }

    public static RecoveryRatio of(final BigDecimal totalPrizeAmount, final BigDecimal purchasedAmount) {
        BigDecimal recoveryRatio = totalPrizeAmount.divide(purchasedAmount, MAX_DECIMAL_POINT_POLICY, HALF_UP);
        BigDecimal recoveryPercentage = recoveryRatio.multiply(ONE_HUNDRED);
        BigDecimal reScaledPercentage = recoveryPercentage.setScale(DECIMAL_POINT_POLICY, HALF_UP);
        return RecoveryRatio.from(reScaledPercentage);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        RecoveryRatio rate = (RecoveryRatio) that;
        return rate.value.equals(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        double recoveryRatio = value.doubleValue();
        return formatter.format(recoveryRatio);
    }
}
