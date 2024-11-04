package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;

public class BonusNumberInputValidator {

    private static final String NUMERIC_REGEX = "\\d+";

    public static void validateBonusNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsNumeric(input);
        validateIsInIntegerRange(input);
    }

    private static void validateIsNumeric(String input) {
        if (isNotNumeric(input)) {
            throw new LottoException(LottoErrorMessage.INPUT_IS_NOT_NUMERIC);
        }
    }

    private static void validateIsInIntegerRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    private static boolean isNotNumeric(String input) {
        return !input.matches(NUMERIC_REGEX);
    }
}
