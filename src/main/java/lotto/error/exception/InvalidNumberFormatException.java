package lotto.error.exception;

import lotto.error.ErrorType;

public class InvalidNumberFormatException extends GeneralException {
    public InvalidNumberFormatException(final ErrorType errorType) {
        super(errorType);
    }
}
