package lotto.exception;

import lotto.message.ErrorMessage;

public final class InvalidPurchaseAmountException extends IllegalArgumentException {
    public InvalidPurchaseAmountException() {
        super(ErrorMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
    }
}
