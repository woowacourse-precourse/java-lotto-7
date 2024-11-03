package lotto.validation;

import static lotto.constant.Policy.WINNER_NUMBER_INPUT_REGEX;

import lotto.constant.ExceptionMessage;

public class InputValidator {

    public void validateInputIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY);
        }
    }

    public void validateValidCharacter(String input) {
        if (!input.matches(WINNER_NUMBER_INPUT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNER_NUMBER_INPUT_INVALID_CHARACTER);
        }
    }
}
