package lotto.util;

import lotto.exception.GeneralExceptionMessages;

public class NumberConverter{

    public int convertNumber(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty() || !trimmedInput.matches("\\d+")) {
            throw new IllegalArgumentException(GeneralExceptionMessages.INVALID_NUMBER);
        }

        try {
            return Integer.parseInt(trimmedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GeneralExceptionMessages.INVALID_NUMBER);
        }
    }
}
