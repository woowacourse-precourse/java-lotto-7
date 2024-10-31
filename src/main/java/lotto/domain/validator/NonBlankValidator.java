package lotto.domain.validator;

import static lotto.common.exception.ErrorMessages.BLANK_NOT_ALLOWED;

public class NonBlankValidator implements InputValidator {
    @Override
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED.toString());
        }
    }
}
