package lotto.validator;

import lotto.constant.ErrorMessage;

public class InputValidator {
    public static void validateBlank(String value) {
        if (isBlank(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_BLANK_ERROR);
        }
    }

    public static void validateWhitespace(String value) {
        if (hasWhitespace(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_WITH_BLANK_ERROR);
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private static boolean hasWhitespace(String value) {
        return value.contains(" ");
    }
}
