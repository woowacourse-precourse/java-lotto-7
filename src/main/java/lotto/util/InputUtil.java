package lotto.util;

import static lotto.exception.ExceptionMessage.EMPTY_INPUT;

public class InputUtil {
    public static void validateEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }
}
