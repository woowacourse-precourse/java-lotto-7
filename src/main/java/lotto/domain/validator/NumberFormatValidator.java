package lotto.domain.validator;

import static lotto.common.exception.ErrorMessages.MUST_BE_WHOLE_NUMBER;

public class NumberFormatValidator implements InputValidator {
    private static final String NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";

    @Override
    public void validate(String input) {
        if (!input.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(MUST_BE_WHOLE_NUMBER.toString());
        }
    }
}
