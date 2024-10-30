package lotto.exception.io;

import lotto.exception.ErrorMessage;

public class InputValidation {

    private static final String NUMERIC_REGEX = "^[0-9]*$";

    public static void validate(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }

        if (isContainBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONTAIN_BLANK.getErrorMessage());
        }

        if (isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMERIC.getErrorMessage());
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isContainBlank(String input) {
        return input.contains(" ");
    }

    private static boolean isNumeric(String input) {
        return !input.matches(NUMERIC_REGEX);
    }
}
