package lotto.util;

import lotto.exception.InputErrorMessage;

public class InputValidator {

    public static void validateAmount(String input) {
        validateNumericInput(input);
    }


    private static void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_NUMERIC_AMOUNT.getMessage());
        }
    }
}
