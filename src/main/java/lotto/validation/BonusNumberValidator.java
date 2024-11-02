package lotto.validation;

import lotto.enums.ErrorMessage;

public class BonusNumberValidator {

    public static void validateBonusNumber(String input) {
        validateNull(input);
        validateStartZero(input);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateStartZero(String input) {
        if (input.trim().equals("0") || input.trim().matches("^0\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_START_WITH_ZERO.getErrorMessage());
        }
    }

}
