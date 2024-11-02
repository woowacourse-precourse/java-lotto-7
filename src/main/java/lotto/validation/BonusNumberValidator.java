package lotto.validation;

import lotto.enums.ErrorMessage;

public class BonusNumberValidator {

    public static void validateWinningNumber(String input) {
        validateNull(input);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

}
