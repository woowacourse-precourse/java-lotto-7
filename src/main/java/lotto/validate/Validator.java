package lotto.validate;

import lotto.constants.ErrorMessage;

public class Validator {

    protected static void isEmpty(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    protected static int parseToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_TYPE.getMessage());
        }
    }
}
