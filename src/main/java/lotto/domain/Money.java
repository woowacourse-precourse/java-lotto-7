package lotto.domain;

import lotto.enums.ErrorMessage;

public class Money {
    private final int ZERO = 0;
    private final int UNIT_OF_PURCHASE_AMOUNT = 1_000;

    private final int amount;

    private Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    private void validate(final int amount) {
        validatePositiveInteger(amount);
        validateUnit(amount);
    }

    private void validatePositiveInteger(final int amount) {
        boolean isValid = (ZERO < amount);
        if (!isValid) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT_NOT_ALLOWED.getMessage());
        }
    }

    private void validateUnit(final int amount) {
        boolean isValid = (amount % UNIT_OF_PURCHASE_AMOUNT == ZERO);
        if (!isValid) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
