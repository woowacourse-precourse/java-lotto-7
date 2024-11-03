package lotto.util.validator;

import lotto.message.ExceptionMessage;

public class NumberValidator {

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_A_NUMBER);
        }
    }
}
