package lotto.domain.validator;

import static lotto.common.constant.ErrorMessages.BLANK_NOT_ALLOWED;

import java.util.List;

public class NonBlankValidator implements InputValidator {

    @Override
    public void validate(String input) {
        validateNull(input);
        String trimmedInput = input.trim();
        validateEmpty(trimmedInput);
    }

    @Override
    public void validate(List<Integer> numbers) {
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
