package lotto.common.validator;

import lotto.error.InputErrorMessage;

public class InputValidator {
    public static void validate(String input) {
        checkBlank(input);
    }

    private static void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(InputErrorMessage.NON_BLANK
                    .getMessage());
        }
    }
}
