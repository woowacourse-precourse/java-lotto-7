package lotto.util;

import static lotto.constant.ExceptionMessage.INPUT_TOO_LONG;
import static lotto.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static lotto.constant.ExceptionMessage.NULL_OR_EMPTY_INPUT;

public class NumberParser {
    private static final int INTEGER_MAX_DIGITS = 10;
    private static final int LONG_MAX_DIGITS = 19;

    private NumberParser() {
    }

    public static Long parseLong(String input) {
        return parseNumber(input, LONG_MAX_DIGITS, NumberParser::parseToLong);
    }

    public static Integer parseInt(String input) {
        return parseNumber(input, INTEGER_MAX_DIGITS, NumberParser::parseToInteger);
    }

    private static <T> T parseNumber(String input, int maxDigits, Parser<T> parser) {
        validate(input, maxDigits);
        return parser.parse(input.strip());
    }

    private static void validate(String input, int maxDigits) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT.message());
        }
        if (input.strip().length() >= maxDigits) {
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

    private static Integer parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.message());
        }
    }

    @FunctionalInterface
    private interface Parser<T> {
        T parse(String input);
    }
}
