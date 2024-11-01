package lotto.io.exception;

import lotto.io.error.ErrorMessage;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException(final String message) {
        super(message);
    }

    public static EmptyInputException emptyPurchaseAmount() {
        return new EmptyInputException(ErrorMessage.EMPTY_INPUT_PURCHASE_AMOUNT);
    }

    public static EmptyInputException emptyLottoNumbers() {
        return new EmptyInputException(ErrorMessage.EMPTY_INPUT_LOTTO_NUMBER);
    }
}
