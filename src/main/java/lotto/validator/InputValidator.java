package lotto.validator;

import lotto.constant.ErrorMessage;

public class InputValidator implements Validator {
    String input;

    public InputValidator(String input) {
        this.input = input;
    }

    @Override
    public void validate() throws IllegalArgumentException {
        validateInputIsBlank();
    }

    public void validateInputIsBlank() {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.get());
        }
    }
}
