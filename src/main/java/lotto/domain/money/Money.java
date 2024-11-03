package lotto.domain.money;

import lotto.common.exception.InvalidMoneyException;

public class Money {

    private static final int MIN_MONEY_VALUE = 1000;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if(money < MIN_MONEY_VALUE || money % MIN_MONEY_VALUE != 0) {
            throw new InvalidMoneyException(money);
        }
    }
}
