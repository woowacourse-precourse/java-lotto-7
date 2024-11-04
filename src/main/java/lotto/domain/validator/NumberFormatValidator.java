package lotto.domain.validator;

import static lotto.common.constant.ErrorMessages.*;

import java.util.List;

public class NumberFormatValidator implements InputValidator {
    private static final String NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";
    private static final int NUMBER_ONE = 1;

    @Override
    public void validate(String input) {
        validateNumber(input);
        validatePositive(input);
    }

    @Override
    public void validate(List<Integer> numbers) {
    }

    public void validateNumber(String input) {
        if (!input.trim().matches(NUMBER_REGULAR_EXPRESSION) || input.trim().isEmpty()) {
            throw new IllegalArgumentException(MUST_BE_WHOLE_NUMBER.toString());
        }
    }

    public void validatePositive(String input) {
        int i = Integer.parseInt(input.trim());
        if (i < NUMBER_ONE) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE_NUMBER.toString());
        }
    }
}
