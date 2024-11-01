package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.BLANK_INPUT;
import static lotto.util.message.ExceptionMessage.NOT_INTEGER;
import static lotto.util.message.ExceptionMessage.NOT_POSITIVE_INTEGER;

public class InputValidator {

    public static String validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT.toString());
        }
        return input;
    }

    public static Long validateInteger(String input) {
        try {
            return validatePositive(Long.parseLong(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.toString());
        }
    }
    private static Long validatePositive(Long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER.toString());
        }
        return number;
    }
}
