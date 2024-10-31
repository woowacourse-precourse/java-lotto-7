package lotto.validation;

import lotto.constant.ExceptionMessage;

public class InputValidator {

    public void validateInputIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY);
        }
    }
}
