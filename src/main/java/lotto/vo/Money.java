package lotto.vo;

import static lotto.constant.ExceptionMessage.AMOUNT_MUST_BE_NON_NEGATIVE;

import java.util.Objects;

public class Money {
    private final long value;

    private Money(long value) {
        validatePositive(value);
        this.value = value;
    }

    public static Money from(long amount) {
        return new Money(amount);
    }

    private void validatePositive(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(AMOUNT_MUST_BE_NON_NEGATIVE.message());
        }
    }

    public Money add(Money other) {
        return new Money(this.value + other.value);
    }

    public Money subtract(Money other) {
        long result = this.value - other.value;
        if (result < 0) {
            throw new IllegalArgumentException(AMOUNT_MUST_BE_NON_NEGATIVE.message());
        }

        return new Money(result);
    }

    public boolean isDivisibleBy(Money other) {
        return this.value % other.value == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money money)) {
            return false;
        }
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
