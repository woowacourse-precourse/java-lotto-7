package lotto.util;

import static lotto.constant.ErrorMessages.EMPTY_INPUT_ERROR;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }
}
