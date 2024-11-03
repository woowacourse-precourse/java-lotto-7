package lotto.exception.money;

import lotto.util.ErrorMessage;

public class ZeroMoneyException extends IllegalArgumentException {
    public ZeroMoneyException() {
        super(ErrorMessage.PURCHASE_MONEY_MINIMUM);
    }
}
