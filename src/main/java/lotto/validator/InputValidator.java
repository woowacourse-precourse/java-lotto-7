package lotto.validator;

import lotto.view.message.ErrorMessage;

public class InputValidator {
    static void validateNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getMessage());
        }
    }

    static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }

    static void validateIsPositive(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
        }
    }
}
