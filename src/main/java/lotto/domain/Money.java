package lotto.domain;

import lotto.validator.MoneyValidator;

public class Money {
    private final int money;

    public Money(int money) {
        MoneyValidator.validateProcess(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }


}
