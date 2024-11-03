package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    public static final Money ZERO = Money.from(0);
    private static final int ZERO_THRESHOLD = 0;
    private static final int DECIMAL_PRECISION = 4;

    private final BigDecimal amount;

    public static Money from(int amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isNotMultipleOf(Money other) {
        return this.amount.remainder(other.amount)
                .compareTo(BigDecimal.ZERO) != ZERO_THRESHOLD;
    }

    public Money plus(Money money) {
        return new Money(this.amount.add(money.amount));
    }

    public Money divide(Money money) {
        return new Money(this.amount.divideToIntegralValue(money.amount));
    }

    public Money divideWithRoundHalfUp(Money money) {
        BigDecimal result = this.amount.divide(money.amount, DECIMAL_PRECISION, RoundingMode.HALF_UP);
        return new Money(result);
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < ZERO_THRESHOLD;
    }

    public boolean isGreaterThan(Money other) {
        return amount.compareTo(other.amount) > ZERO_THRESHOLD;
    }

    public int intValue() {
        return amount.intValue();
    }

    public double doubleValue() {
        return amount.doubleValue();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Money other)) {
            return false;
        }

        return Objects.equals(amount.doubleValue(), other.amount.doubleValue());
    }

    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
