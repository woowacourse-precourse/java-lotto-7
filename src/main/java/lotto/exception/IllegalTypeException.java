package lotto.exception;

import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;

public class IllegalTypeException extends IllegalArgumentException {
    public IllegalTypeException(String input, String type) {
        super(String.format(INVALID_TYPE_INPUT.getMessage(), input, type));
    }
}
