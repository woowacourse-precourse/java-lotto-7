package lotto.domain;

import lotto.exception.MoneyExceptionType;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) throws IllegalArgumentException {
        if (money < 1000 || money > 100000 || money % 1000 != 0) {
            throw new IllegalArgumentException(MoneyExceptionType.OUT_OF_RANGE_MONEY.getMessage());
        }
    }
}
