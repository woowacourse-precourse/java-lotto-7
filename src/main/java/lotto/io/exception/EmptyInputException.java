package lotto.io.exception;

import lotto.io.error.ErrorMessage;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException(final String message) {
        super(message);
    }

    public static EmptyInputException emptyInput() {
        return new EmptyInputException(ErrorMessage.EMPTY_INPUT);
    }
}
