package lotto.validator;

import lotto.constants.ExceptionMessage;

public class Validator {
    public static int validateAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessage.INVALID_TYPE_INPUT);
        }
    }
}
