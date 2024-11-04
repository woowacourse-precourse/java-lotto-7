package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;

public class CommonInputValidator {

    private static final String WHITE_SPACE = " ";

    public static void validateCommonInput(String input) {
        validateIsNotEmptyInput(input);
        validateHasNoWhiteSpace(input);
    }

    public static void validateIsInIntegerRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    private static void validateIsNotEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new LottoException(LottoErrorMessage.INPUT_IS_EMPTY);
        }
    }

    private static void validateHasNoWhiteSpace(String input) {
        if (input.contains(WHITE_SPACE)) {
            throw new LottoException(LottoErrorMessage.INPUT_CONTAINS_WHITE_SPACE);
        }
    }
}
