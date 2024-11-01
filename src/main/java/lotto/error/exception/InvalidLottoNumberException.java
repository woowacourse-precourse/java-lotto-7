package lotto.error.exception;

import lotto.error.ErrorType;

public class InvalidLottoNumberException extends GeneralException {
    public InvalidLottoNumberException(final ErrorType errorType) {
        super(errorType);
    }
}
