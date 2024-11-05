package lotto.validator;

import lotto.constant.ErrorMessage;

public class InputValidator {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public static void validateBlank(String value) {
        if (isBlank(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_BLANK_ERROR);
        }
    }

    public static void validateWhitespace(String value) {
        if (hasWhitespace(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_WITH_BLANK_ERROR);
        }
    }

    public static void validateLetter(String input) {
        if (isLetter(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER_CHARACTER_ERROR);
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private static boolean hasWhitespace(String value) {
        return value.contains(" ");
    }

    private static boolean isLetter(String input) {
        return !(input.matches(SIGNED_NUMBER_REGEX));
    }

}
