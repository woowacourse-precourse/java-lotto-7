package lotto.model;

import lotto.exception.LottoGameException;
import lotto.exception.MoneyException;

public class Money {

    private final int amount;

    private Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new LottoGameException(MoneyException.INVALID_AMOUNT);
        }
    }

}
