package lotto.exception.money;

import lotto.util.ErrorMessage;

public class MaximumMoneyException extends IllegalArgumentException {
    public MaximumMoneyException() {
        super(ErrorMessage.PURCHASE_MONEY_MAXIMUM);
    }
}
