package lotto.validator;

import lotto.enums.ErrorMessage;

public class InputValidator {
    private static final String DOUBLE_COMMA = ",,";
    private static final String NUMBER_PATTERN = "-?\\d+";
    private static final String COMMA = ",";

    private InputValidator() {
    }

    public static void validateInteger(String input) {
        validateBlank(input);
        validateInt(input);
    }

    public static void validateWinningNumbers(String input) {
        validateBlank(input);
        validateCommaSeparatedSyntax(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }

    private static void validateInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
        }
    }

    private static void validateCommaSeparatedSyntax(String input) {
        if (input.contains(DOUBLE_COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }

        String[] numbers = input.split(COMMA);
        for (String number : numbers) {
            if (!number.trim().matches(NUMBER_PATTERN)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
            }
        }
    }
}
