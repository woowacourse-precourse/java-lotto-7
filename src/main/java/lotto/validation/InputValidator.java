package lotto.validation;

import static lotto.util.ExceptionMessage.INVALID_AMOUNT_UNIT;

public class InputValidator {
    public static void isZero(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }

    public static void idValidateAmountUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }
}
