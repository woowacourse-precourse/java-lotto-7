package lotto.view;

import static lotto.constant.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateEmptyInput(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateDivisibleByThousand(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE.getMessage());
        }
    }
}
