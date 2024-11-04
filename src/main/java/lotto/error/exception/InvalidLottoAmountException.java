package lotto.error.exception;

import lotto.error.ErrorType;

public class InvalidLottoAmountException extends GeneralException {

    public InvalidLottoAmountException(final ErrorType errorType) {
        super(errorType);
    }
}
