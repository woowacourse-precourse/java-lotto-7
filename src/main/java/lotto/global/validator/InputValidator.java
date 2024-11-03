package lotto.global.validator;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class InputValidator {

    public static void validate(final String input) {
        validateNumberFormat(input);
    }

    private static void validateNumberFormat(final String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw LottoException.of(ErrorMessage.INVALID_NUMBER_FORMAT, e);
        }
    }
}
