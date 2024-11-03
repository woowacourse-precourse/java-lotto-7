package lotto.validator;

import lotto.enums.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateInteger(String input) {
        validateBlank(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }
}
