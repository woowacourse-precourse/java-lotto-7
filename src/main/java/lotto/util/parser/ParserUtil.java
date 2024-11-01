package lotto.util.parser;

import lotto.exception.InputErrorMessage;

public class ParserUtil {

    private ParserUtil() {
    }

    public static int convertToNumber(String input) {
        validateNotEmpty(input);
        validateNumericFormat(input);
        return Integer.parseInt(input);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumericFormat(String input) {
        if (!input.matches("\\d+")) {  // 숫자 형식이 아니면 예외 발생
            throw new IllegalArgumentException(InputErrorMessage.INVALID_NUMERIC_FORMAT.getMessage());
        }
    }
}
