package lotto.exception;

import static lotto.constants.ExceptionMessages.BUY_AMOUNT_HAS_CHANGE;

public class BuyAmountHasChangeException extends IllegalArgumentException {
    public BuyAmountHasChangeException() {
        super(BUY_AMOUNT_HAS_CHANGE);
    }
}
