package lotto.validator;

import lotto.exception.ErrorMessage;

public class InputValidator {
    public static void validatePrice(String input) {
        isEmpty(input);
        isNumber(input);
        isPositive(input);
    }

    private static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY_VALUE.getMessage());
        }
    }

    private static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    private static void isPositive(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NEGATIVE_NUMBER.getMessage());
        }
    }
}
