package lotto.util;

import lotto.enums.ErrorMessage;

public abstract class Validator {
    private static final String NUMBER_PATTERN = "^[0-9]+$";

    public static boolean isPatternNotMatched(String input, String pattern) {
        return input == null || !input.matches(pattern);
    }

    public static void checkNumberForm(String input) {
        if (isPatternNotMatched(input, NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORM.format());
        }
    }
}
