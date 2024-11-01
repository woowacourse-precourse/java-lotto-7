package lotto.error.exception;

import lotto.error.ErrorType;

public class InvalidLottoPurchaseAmount extends GeneralException {

    public InvalidLottoPurchaseAmount(final ErrorType errorType) {
        super(errorType);
    }
}
