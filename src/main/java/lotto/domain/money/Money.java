package lotto.domain.money;

import lotto.common.exception.InvalidMoneyException;

public class Money {

    private static final int MIN_MONEY_VALUE = 1000;

    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    public long getMoney() {
        return this.money;
    }

    private void validateMoney(long money) {
        if(money < MIN_MONEY_VALUE || money % MIN_MONEY_VALUE != 0) {
            throw new InvalidMoneyException(money);
        }
    }
}
