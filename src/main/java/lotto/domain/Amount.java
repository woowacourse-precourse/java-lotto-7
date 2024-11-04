package lotto.domain;

import static lotto.error.ThrowException.throwIllegalArgumentException;

import lotto.error.Error;

public class Amount {

    private final int MINIMUM_UNIT = 1000;
    private final int MAXIMUM_AMOUNT = 100000000;

    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validatePositiveAmount(amount);
        validateMaximum(amount);
        validateMultipleOfMinimumUnit(amount);
    }

    private void validatePositiveAmount(int amount) {
        boolean validatePositive = amount <= 0;
        String errorFormat = Error.NON_POSITIVE_AMOUNT_ERROR.getMessage();
        throwIllegalArgumentException(validatePositive, errorFormat);
    }

    private void validateMaximum(int amount) {
        boolean validateMaximum = amount > MAXIMUM_AMOUNT;
        String errorFormat = Error.GREATER_THAN_MAXIMUM_AMOUNT_ERROR.format(MAXIMUM_AMOUNT);
        throwIllegalArgumentException(validateMaximum, errorFormat);
    }

    private void validateMultipleOfMinimumUnit(int amount) {
        boolean validateMultiple = amount % MINIMUM_UNIT != 0;
        String errorFormat = Error.NOT_GREATER_THAN_MINNIMUM_AMOUNT_UNIT_ERROR.getMessage();
        throwIllegalArgumentException(validateMultiple, errorFormat);
    }

    public int getAmount() {
        return amount;
    }

}
