package lotto.domain;

import lotto.exception.MoneyExceptionType;

public class Money {
    private static final int MINIMUM_MONEY = 1000;
    private static final int MAXIMUM_MONEY = 100000;
    private static final int LOTTO_PRIZE = 1000;

    private final int money;

    public Money(int money) {
        validateRange(money);
        validateDivision(money);
        this.money = money;
    }

    private void validateRange(int money) throws IllegalArgumentException {
        if (money < MINIMUM_MONEY || money > MAXIMUM_MONEY) {
            throw new IllegalArgumentException(MoneyExceptionType.OUT_OF_RANGE_MONEY.getMessage());
        }
    }

    private void validateDivision(int money) throws IllegalArgumentException {
        if (money % LOTTO_PRIZE != 0) {
            throw new IllegalArgumentException(MoneyExceptionType.NON_DIVISIBLE_MONEY.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
