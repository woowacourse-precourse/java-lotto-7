package lotto.validator.strategies;

import lotto.view.ErrorMessage;

public class EmptyInputValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String input) {
        validateNotNull(input);
        validateNotBlank(input);
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
        }
    }

    private void validateNotBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
        }
    }

}
