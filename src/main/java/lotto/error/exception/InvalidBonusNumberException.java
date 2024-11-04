package lotto.error.exception;

import lotto.error.ErrorType;

public class InvalidBonusNumberException extends GeneralException {
    public InvalidBonusNumberException(final ErrorType errorType) {
        super(errorType);
    }
}
