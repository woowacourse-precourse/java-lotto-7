package lotto.util;

import static lotto.exception.ExceptionMessage.EMPTY_INPUT;
import static lotto.exception.ExceptionMessage.ONLY_POSITIVE_INPUT;

public class InputUtil {

    private static final String DECIMAL_POINT = ".";
    private static final String ZERO = "0";
    private static final String NEGATIVE_SIGN = "-";

    public static void validateEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    public static void validatePositiveInteger(String input){
        if (input.startsWith(NEGATIVE_SIGN) || ZERO.equals(input) || input.contains(DECIMAL_POINT)) {
            throw new IllegalArgumentException(ONLY_POSITIVE_INPUT.getMessage());
        }
    }

}
