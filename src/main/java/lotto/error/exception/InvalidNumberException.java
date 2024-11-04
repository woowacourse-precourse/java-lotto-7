package lotto.error.exception;

import lotto.error.AppException;

public class InvalidNumberException extends AppException {
    public InvalidNumberException(final String errorType) {
        super(errorType);
    }
}
