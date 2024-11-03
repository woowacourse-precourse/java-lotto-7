package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.MoneyException;

import java.math.BigDecimal;

public record Money(int amount) {
    public Money {
        validate(amount);
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    private static void validate(int amount) {
        validateNonNegative(amount);
        validateAmountInThousands(amount);
    }

    private static void validateNonNegative(int amount) {
        if (amount < 0) {
            throw new MoneyException(ErrorMessages.AMOUNT_INVALID);
        }
    }

    private static void validateAmountInThousands(int amount) {
        if (amount % 1000 != 0) {
            throw new MoneyException(ErrorMessages.AMOUNT_INVALID);
        }
    }

    public int divide(int value) {
        if (value == 0) {
            throw new MoneyException(ErrorMessages.DIVIDE_BY_ZERO);
        }
        return amount / value;
    }

    public boolean isZero() {
        return amount == 0;
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(amount);
    }

    public Money plus(Money other) {
        if (other == null) {
            throw new MoneyException(ErrorMessages.OTHER_NULL);
        }
        return new Money(this.amount + other.amount());
    }
}
