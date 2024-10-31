package lotto.model;

import lotto.utils.ExceptionMessage;

public class Budget {
    private static final int BASE_MONEY = 1000;

    private final int money;

    public Budget(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % BASE_MONEY != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_BUDGET.getMessage());
        }
    }

    public int calculateNumberOfLotto() {
        return money / BASE_MONEY;
    }
}
