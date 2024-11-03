package lotto.validation;

import lotto.domain.WinningNumber;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoValue;
import lotto.enums.RegexPattern;

public class BonusNumberValidator {

    public static void validateBonusNumber(String input) {
        validateNull(input);
        validateStartZero(input);
        validateNumericInput(input);
    }

    public static void validateConvertBonusNumber(int input, WinningNumber winningNumber) {
        validateRange(input);
        validateDuplicateWinningNumber(input, winningNumber);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateStartZero(String input) {
        if (input.equals("0") || RegexPattern.START_WITH_ZERO.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_START_WITH_ZERO.getErrorMessage());
        }
    }

    private static void validateRange(int input) {
        if (input < LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue()
                || input > LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ALLOW_ONE_TO_FORTY_FIVE.getErrorMessage());
        }
    }

    private static void validateNumericInput(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_WITHOUT_NUMBER.getErrorMessage());
        }
    }

    private static void validateDuplicateWinningNumber(int input, WinningNumber winningNumber) {
        if (winningNumber.isContain(input)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_DUPLICATE_NUMBER.getErrorMessage());
        }
    }
}
