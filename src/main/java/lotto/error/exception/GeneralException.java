package lotto.error.exception;

import lotto.error.ErrorType;

public class GeneralException extends RuntimeException {
    private final ErrorType errorType;

    protected GeneralException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
