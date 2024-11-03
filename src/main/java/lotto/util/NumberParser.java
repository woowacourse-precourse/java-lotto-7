package lotto.util;

import static lotto.constant.ExceptionMessage.INPUT_TOO_LONG;
import static lotto.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static lotto.constant.ExceptionMessage.NULL_OR_EMPTY_INPUT;

public class NumberParser {
    private static final int MAX_DIGITS_TO_PREVENT_OVERFLOW = 19;

    private NumberParser() {
    }

    public static Long parse(String input) {
        validateNotNull(input);

        String trimmedInput = input.strip();
        validateNotEmpty(trimmedInput);
        validateNotOverflow(trimmedInput);

        return parseToLong(trimmedInput);
    }

    private static void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT.message());
        }
    }

    private static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT.message());
        }
    }

    private static void validateNotOverflow(String input) {
        if (input.length() >= MAX_DIGITS_TO_PREVENT_OVERFLOW) {
            throw new IllegalArgumentException(INPUT_TOO_LONG.message());
        }
    }

    private static Long parseToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.message());
        }
    }
}
