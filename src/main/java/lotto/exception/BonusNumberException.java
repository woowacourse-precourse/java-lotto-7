package lotto.exception;

import lotto.common.constant.ErrorMessage;

public class BonusNumberException extends IllegalArgumentException {
    private final ErrorMessage errorMessage;

    public BonusNumberException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void printErrorMessage() {
        errorMessage.printErrorMessage();
    }
}
