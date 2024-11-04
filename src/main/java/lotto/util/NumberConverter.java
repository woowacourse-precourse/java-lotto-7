package lotto.util;

import lotto.exception.GeneralExceptionMessages;

public class NumberConverter{
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public int convertNumber(String input) {
        validateInput(input);
        return parseNumber(input);
    }

    private void validateInput(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty() || !trimmedInput.matches(REGEXP_PATTERN_NUMBER)) {
            throw new IllegalArgumentException(GeneralExceptionMessages.INVALID_NUMBER);
        }
    }

    private int parseNumber(String input) {
        return Integer.parseInt(input.trim());
    }

}
