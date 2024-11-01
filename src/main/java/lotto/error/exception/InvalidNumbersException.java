package lotto.error.exception;

import lotto.error.AppException;

public class InvalidNumbersException extends AppException {
    public InvalidNumbersException(final String errorType) {
        super(errorType);
    }
}
