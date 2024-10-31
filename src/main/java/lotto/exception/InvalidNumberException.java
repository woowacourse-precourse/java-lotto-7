package lotto.exception;

import lotto.message.ErrorMessage;

public final class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException() {
        super(ErrorMessage.INVALID_NUMBER.getErrorMessage());
    }
}
