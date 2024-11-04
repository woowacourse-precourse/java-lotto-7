package lotto.exception;

import lotto.common.constant.ErrorMessage;

public class PriceToBuyLottoException extends IllegalArgumentException {

    private final ErrorMessage errorMessage;

    public PriceToBuyLottoException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void printErrorMessage() {
        errorMessage.printErrorMessage();
    }
}
