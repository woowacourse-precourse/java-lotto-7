package lotto.model.domain;

import lotto.exception.InputErrorMessage;

public class Money {
    private static final int MIN_AMOUNT = 1000;
    private static final int MAX_AMOUNT = 1000000;
    private static final int DIVISIBILITY_FACTOR = 1000;
    private final int amount;

    public Money(int amount) {
        validateAmountInRange(amount);
        validateDivisibility(amount);
        this.amount = amount;
    }

    private void validateAmountInRange(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(InputErrorMessage.NEGATIVE_OR_ZERO_AMOUNT.getMessage());
        }
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(InputErrorMessage.EXCEEDS_LIMIT_AMOUNT.getMessage());
        }
    }

    private void validateDivisibility(int amount) {
        if (amount % DIVISIBILITY_FACTOR != 0) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
