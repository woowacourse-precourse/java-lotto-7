package lotto.exception;

import static lotto.constant.LottoErrorMessages.INVALID_PURCHASE_AMOUNT;

public class InvalidBuyAmountException extends LottoException {
    public InvalidBuyAmountException() {
        super(INVALID_PURCHASE_AMOUNT);
    }
}
