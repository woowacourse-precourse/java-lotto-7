package lotto.exception;

import lotto.util.ErrorMessage;

public class InputException {
    public static void notNumericException(boolean isNumeric) {
        if (!isNumeric) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMessage());
        }
    }
}
