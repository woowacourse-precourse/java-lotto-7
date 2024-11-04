package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;

public class WinningNumberInputValidator {

    private static final String NUMERIC_REGEX = "\\d+";
    private static final String COMMA = ",";

    public static void validateWinningNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsNumericList(input);
    }

    private static void validateIsNumericList(String input) {
        String[] splitInput = input.split(COMMA);
        for (String s : splitInput) {
            if (isNotNumeric(s)) {
                throw new LottoException(LottoErrorMessage.INVALID_WINNING_NUMBER_FORMAT);
            }
        }
    }

    private static boolean isNotNumeric(String input) {
        return !input.matches(NUMERIC_REGEX);
    }
}
