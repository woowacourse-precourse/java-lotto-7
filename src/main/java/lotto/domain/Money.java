package lotto.domain;

import static lotto.exception.MoneyExceptionType.NOT_UNIT_MONEY;
import static lotto.exception.MoneyExceptionType.ZERO_MONEY;

import lotto.exception.MoneyException;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new MoneyException(ZERO_MONEY);
        }
    }

    private void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new MoneyException(NOT_UNIT_MONEY);
        }
    }

    public int getTicket() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}