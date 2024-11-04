package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;

public class NumberInputValidator {

    private static final String NUMERIC_REGEX = "\\d+";

    public void validateNumberInput(String input) {
        validateIsNumeric(input);
        validateIsInIntegerRange(input);
    }

    private void validateIsNumeric(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new LottoException(LottoErrorMessage.INPUT_IS_NOT_NUMERIC);
        }
    }

    private void validateIsInIntegerRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorMessage.INVALID_NUMBER_RANGE);
        }
    }
}
