package lotto.exception;

import lotto.util.enums.ValidateMessage;

public class InputException {
    public static void notNumericException(boolean isNumeric) {
        if (!isNumeric) {
            throw new IllegalArgumentException(ValidateMessage.NON_NUMERIC_ERROR.getMessage());
        }
    }
}
