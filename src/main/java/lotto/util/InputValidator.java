package lotto.util;

import lotto.util.message.ErrorMessage;

public class InputValidator {

    public static void validateNonEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }

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

    public static void validateNoSpaces(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_SPACE_ERROR);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR);
        }
    }
}
