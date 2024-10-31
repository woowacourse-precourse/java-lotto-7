package lotto.controller;

import static lotto.controller.ErrorMessages.INVALID_PAID_AMOUNT_FORMAT;

public class InputValidator {

    private static final String REGEX_OF_POSITIVE_INTEGER = "^[1-9]\\d*$";

    private InputValidator() {
    }

    public static void validatePaidAmount(String input) {
        if (!input.matches(REGEX_OF_POSITIVE_INTEGER)) {
            throw new IllegalArgumentException(INVALID_PAID_AMOUNT_FORMAT);
        }
    }

}
