package lotto.exception;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;

public class IllegalInputException extends IllegalArgumentException {
    public IllegalInputException() {
        super(INVALID_BLANK_INPUT.getMessage());
    }
}
