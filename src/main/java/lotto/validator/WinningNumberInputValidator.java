package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;

public class WinningNumberInputValidator {

    private static final String NUMERIC_REGEX = "\\d+";
    private static final String COMMA = ",";

    public static void validateWinningNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsIntegerList(input);
    }

    private static void validateIsIntegerList(String input) {
        String[] splitInput = input.split(COMMA);
        for (String s : splitInput) {
            validateIsNumeric(s);
            CommonInputValidator.validateIsInIntegerRange(s);
        }
    }

    private static void validateIsNumeric(String input) {
        if (isNotNumeric(input)) {
            throw new LottoException(LottoErrorMessage.INPUT_IS_NOT_NUMERIC);
        }
    }

    private static boolean isNotNumeric(String input) {
        return !input.matches(NUMERIC_REGEX);
    }
}
