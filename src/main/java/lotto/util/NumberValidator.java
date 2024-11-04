package lotto.util;

import lotto.constant.ExceptionMessage;

public class NumberValidator {
    private static final String NUMBER_PATTERN = "\\d+";

    public static void validateNumberFormat(final String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NON_DIGIT_CHARACTER.getMessage());
        }
    }

    private static boolean isNotNumber(final String input) {
        return !input.matches(NUMBER_PATTERN);
    }

    public static void validateIntegerRange(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_INVALID_INTEGER_RANGE.getMessage());
        }
    }
}
