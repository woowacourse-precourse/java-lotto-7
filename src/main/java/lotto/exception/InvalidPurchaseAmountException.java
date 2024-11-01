package lotto.exception;

import lotto.constant.LottoErrorMessages;

public class InvalidPurchaseAmountException extends RuntimeException {
    public InvalidPurchaseAmountException() {
        super(LottoErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
    }
}
