package lotto.exception;

import static lotto.message.ExceptionMessage.INVALID_RANGE_INPUT;

public class IllegalRangeException extends IllegalArgumentException {
    public IllegalRangeException(String input, int min, int max) {
        super(String.format(INVALID_RANGE_INPUT.getMessage(), input, min, max));
    }
}
