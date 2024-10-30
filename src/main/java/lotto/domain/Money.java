package lotto.domain;

import lotto.constant.LotteryConst;
import lotto.exception.ExceptionMessages;

public class Money {

    private static final int ZERO = 0;

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
        if (amount % LotteryConst.PRICE.getValue() != ZERO) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_CANNOT_DIVISIBLE.getMessage());
        }
    }
}
