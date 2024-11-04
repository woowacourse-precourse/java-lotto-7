package lotto.exception;

import static lotto.message.ExceptionMessage.INVALID_SIZE_INPUT;

public class IllegalSizeException extends IllegalArgumentException {
    public IllegalSizeException(String input, int size, String type) {
        super(String.format(INVALID_SIZE_INPUT.getMessage(), input, size, type));
    }
}
