package lotto.util;

import lotto.util.message.ErrorMessage;

public class InputValidator {

    public static void validateNonNegativeAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT_ERROR);
        }
    }

    public static void validateAmountUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT_ERROR);
        }
    }
}
