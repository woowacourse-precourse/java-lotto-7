package lotto.helper;

import lotto.common.ErrorMessage;

public class InputValidator {
    public static void validateNumeric(final String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.numberParseError);
        }
    }

    private static boolean isNotNumeric(final String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
