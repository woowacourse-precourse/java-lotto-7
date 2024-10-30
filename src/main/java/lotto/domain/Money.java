package lotto.domain;

import lotto.exception.ExceptionMessages;

public class Money {

    private static final int ZERO = 0;
    private static final int LOTTERY_PRICE = 1000;

    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateNegativeDigit(amount);
        validateCannotDivisible(amount);
    }

    private void validateNegativeDigit(int amount) {
        if (amount < ZERO) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_CANNOT_BE_NEGATIVE_DIGIT.getMessage());
        }
    }

    private void validateCannotDivisible(int amount) {
        if (amount % LOTTERY_PRICE != ZERO) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_CANNOT_DIVISIBLE.getMessage());
        }
    }
}
