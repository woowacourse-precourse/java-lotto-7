package lotto.validation;

import static lotto.constants.ExceptionMessage.INVALID_INPUT;
import static lotto.constants.LottoConfig.AMOUNT_UNIT;
import static lotto.constants.LottoConfig.ZERO;

import static lotto.constants.ExceptionMessage.INVALID_AMOUNT_UNIT;

public class InputMoneyValidator {
    public static String beforeParseValidate(String value) {
        isMinus(value);
        isNumeric(value);
        isNull(value);
        return value;
    }

    public int afterParseValidate(int money) {
        isZero(money);
        idValidateAmountUnit(money);
        return money;
    }

    private void isZero(int money) {
        if (money == ZERO.getValue()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }

    private void idValidateAmountUnit(int money) {
        if (money % AMOUNT_UNIT.getValue() != ZERO.getValue()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }

    private static void isMinus(String value) {
        if (value.startsWith("-")) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }

    private static void isNull(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.format());
        }
    }

    private static void isNumeric(String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_INPUT.format());
        }
    }
}