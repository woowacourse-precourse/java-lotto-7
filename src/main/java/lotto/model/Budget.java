package lotto.model;

import lotto.utils.ExceptionMessage;

public class Budget {
    private static final int BASE_MONEY = 1000;

    private final long money;

    public Budget(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money % BASE_MONEY != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_BUDGET.getMessage());
        }
    }

    public long calculateNumberOfLotto() {
        return money / BASE_MONEY;
    }
}
