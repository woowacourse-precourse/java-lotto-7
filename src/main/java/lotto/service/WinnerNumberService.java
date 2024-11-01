package lotto.service;

import static lotto.constant.Policy.WINNER_NUMBER_INPUT_REGEX;

import lotto.constant.ExceptionMessage;
import lotto.validation.InputValidator;

public class WinnerNumberService {

    private final InputValidator inputValidator;

    public WinnerNumberService(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void validate(String input) {
        inputValidator.validateInputIsEmpty(input);
        validateValidCharacter(input);
    }

    private void validateValidCharacter(String input) {
        if (!input.matches(WINNER_NUMBER_INPUT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNER_NUMBER_INPUT_INVALID_CHARACTER);
        }
    }
}
