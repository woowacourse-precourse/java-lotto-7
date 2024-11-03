package lotto.io;

import lotto.exception.InputValidationError;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateIsEmpty(final String input) {
        if (input.isEmpty()) {
            InputValidationError.EMPTY_INPUT.throwException();
        }
    }

    public static void validateIsNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            InputValidationError.INVALID_NUMERIC_FORMAT.throwException();
        }
    }
}
