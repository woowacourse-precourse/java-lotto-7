package lotto.exception.money;

import lotto.util.ErrorMessage;

public class DivideMoneyException extends IllegalArgumentException {
    public DivideMoneyException() {
        super(ErrorMessage.PURCHASE_MONEY_DIVIDE);
    }
}
