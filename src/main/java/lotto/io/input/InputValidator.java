package lotto.io.input;

import lotto.io.output.ErrorMessage;

public class InputValidator {

    private static final int ONE_THOUSAND = 1000;

    public static void validatePriceIsInThousandUnit(int price) {
        if (price % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.getMessage());
        }
    }

    public static void validateIsNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public static void hasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_INPUT.getMessage());
        }
    }
}