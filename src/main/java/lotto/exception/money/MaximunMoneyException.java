package lotto.exception.money;

import lotto.util.ErrorMessage;

public class MaximunMoneyException extends IllegalArgumentException {
    public MaximunMoneyException() {
        super(ErrorMessage.PURCHASE_MONEY_MAXIMUM);
    }
}
