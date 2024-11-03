package lotto.validator;

import lotto.enums.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateInteger(String input) {
        validateBlank(input);
        validateInt(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }

    private static void validateInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
        }
    }
}
