package lotto.service;

import lotto.validation.InputValidator;

public class BonusNumberService {

    private final InputValidator inputValidator;

    public BonusNumberService(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void validate(String input) {
        inputValidator.validateInputIsEmpty(input);
    }
}
