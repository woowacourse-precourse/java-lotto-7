package lotto.exception;

import lotto.common.constant.ErrorMessage;

public class LottoException extends IllegalArgumentException {
    private final ErrorMessage errorMessage;

    public LottoException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void printErrorMessage() {
        errorMessage.printErrorMessage();
    }
}
