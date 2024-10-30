package lotto.exception;

import static lotto.error.ErrorMessage.INVALID_UNIT_AMOUNT;

public class InvalidUnitAmountException extends IllegalArgumentException {
    private InvalidUnitAmountException(final String message) {
        super(message);
    }

    public static InvalidUnitAmountException invalidUnitAmount() {
        throw new InvalidUnitAmountException(INVALID_UNIT_AMOUNT);
    }
}
