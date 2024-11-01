package lotto.domain.validator;

import static lotto.common.exception.ErrorMessages.BLANK_NOT_ALLOWED;

public class NonBlankValidator implements InputValidator {

    @Override
    public void validate(String input) {
        validateNull(input);
        String trimmedInput = input.trim();
        validateEmpty(trimmedInput);
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED.toString());
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED.toString());
        }
    }
}
