package lotto.exception;

import lotto.common.constant.ErrorMessage;

public class WinningLottoNumberException extends IllegalArgumentException {
    private final ErrorMessage errorMessage;

    public WinningLottoNumberException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void printErrorMessage() {
        errorMessage.printErrorMessage();
    }
}
