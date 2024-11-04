package lotto.exception.io;

import lotto.exception.ErrorMessage;

public class InputValidation {

    private static final String BLANK_SPACE = " ";
    private static final String WINNING_NUMBERS_DELIMITER = "^-?\\d+(,-?\\d+)*$";

    private InputValidation() {
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    public static void validateContainBlank(String input) {
        if (input.contains(BLANK_SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_BLANK.getErrorMessage());
        }
    }

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMERIC.getErrorMessage());
        }
    }

    public static void validateDelimiter(String input) {
        if (isNotMatches(input)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DELIMITER.getErrorMessage());
        }
    }

    private static boolean isNotMatches(String input) {
        return !input.matches(WINNING_NUMBERS_DELIMITER);
    }
}
