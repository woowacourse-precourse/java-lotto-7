package lotto.exception;

import lotto.common.constant.ErrorMessage;

public class LottoFactoryException extends IllegalArgumentException {
    private final ErrorMessage errorMessage;

    public LottoFactoryException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void printErrorMessage() {
        errorMessage.printErrorMessage();
    }
}
