package lotto.model;

import static lotto.constant.ErrorMessage.NEGATIVE_MONEY;

public class Money {
    private static final double TO_PERCENTAGE = 100.0;

    protected final int money;

    public Money(final int money) {
        validate(money);
        this.money = money;
    }

    private void validate(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY.getMessage());
        }
    }

    public double getEarningRate(Money earned) {
        return TO_PERCENTAGE * earned.money / this.money;
    }

    public int toInteger() {
        return money;
    }
}
