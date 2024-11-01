package lotto.validation;

import static lotto.util.ExceptionMessage.INVALID_AMOUNT_UNIT;

public class InputValidator {
    public int validate(int value) {
        isZero(value);
        idValidateAmountUnit(value);
        return value;
    }

    private void isZero(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }

    private void idValidateAmountUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }
}
