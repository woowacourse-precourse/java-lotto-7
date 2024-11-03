package lotto.util;

public class ValidatorUtils {
    private static final String EMPTY_VALUE_ERROR_MESSAGE = "빈 값은 입력하실 수 없습니다.";
    private static final String NOT_INT_VALUE_ERROR_MESSAGE = "숫자를 입력하셔야 합니다.";
    private static final String INVALID_RANGE_ERROR_MESSAGE = "1 ~ 45 사이의 수를 입력하셔야 합니다.";

    public static String isNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }
        return input;
    }

    public static int canParseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT_VALUE_ERROR_MESSAGE);
        }
    }

    public static int isInRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
        return input;
    }
}
