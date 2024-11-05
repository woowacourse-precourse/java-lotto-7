package lotto.exception;

import static lotto.constants.ExceptionMessages.ILLEGAL_INPUT_READ;

public class IllegalInputReadException extends IllegalArgumentException {
    public IllegalInputReadException() {
        super(ILLEGAL_INPUT_READ);
    }
}
