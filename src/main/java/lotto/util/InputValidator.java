package lotto.util;

import lotto.exception.InputErrorMessage;

public class InputValidator {

    public static void validateAmount(String input) {
        validateNotEmpty(input);
        validateNumericInput(input);
    }

    private static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage());
        }
    }
    private static void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_NUMERIC_AMOUNT.getMessage());
        }
    }
}
