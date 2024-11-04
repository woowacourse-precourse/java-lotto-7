package lotto.model;

import static lotto.validation.MoneyValidator.validateMoney;

public class Money {
    public static final int MONEY_UNIT = 1000;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getQuantity() {
        return money / MONEY_UNIT;
    }

    public int getMoney() {
        return money;
    }
}
