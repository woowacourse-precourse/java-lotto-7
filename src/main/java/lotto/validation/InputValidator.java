package lotto.validation;

import lotto.exception.ErrorMessage;

public class InputValidator {

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_EMPTY.getMessage());
        }
    }
}
