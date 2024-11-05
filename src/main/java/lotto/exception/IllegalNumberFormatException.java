package lotto.exception;

import static lotto.constants.ExceptionMessages.ILLEGAL_NUMBER_FORMAT;

public class IllegalNumberFormatException extends IllegalArgumentException {
    public IllegalNumberFormatException() {
        super(ILLEGAL_NUMBER_FORMAT);
    }
}
