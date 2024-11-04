package lotto.util;

import lotto.exception.GeneralExceptionMessages;

public class NumberConverter{

    public int convertNumber(String input) {
        validateInput(input);
        return parseNumber(input);
    }

    private void validateInput(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty() || !trimmedInput.matches(RegexConstants.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(GeneralExceptionMessages.INVALID_NUMBER);
        }
    }

    private int parseNumber(String input) {
        return Integer.parseInt(input.trim());
    }

}
