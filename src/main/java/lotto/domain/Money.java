package lotto.domain;

import lotto.exception.MoneyExceptionType;

public class Money {
    private static final long MINIMUM_MONEY = 1000;
    private static final long MAXIMUM_MONEY = 100000;
    private static final long LOTTO_PRIZE = 1000;

    private final long money;

    public Money(long money) {
        validateRange(money);
        validateDivision(money);
        this.money = money;
    }

    private void validateRange(long money) throws IllegalArgumentException {
        if (money < MINIMUM_MONEY || money > MAXIMUM_MONEY) {
            throw new IllegalArgumentException(MoneyExceptionType.OUT_OF_RANGE_MONEY.getMessage());
        }
    }

    private void validateDivision(long money) throws IllegalArgumentException {
        if (money % LOTTO_PRIZE != 0) {
            throw new IllegalArgumentException(MoneyExceptionType.NON_DIVISIBLE_MONEY.getMessage());
        }
    }

    public long getMoney() {
        return money;
    }
}
