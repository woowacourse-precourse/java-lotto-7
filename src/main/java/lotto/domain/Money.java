package lotto.domain;

import lotto.exception.InvalidInputMoneyDivideException;
import lotto.exception.InvalidInputMoneyZeroException;

public class Money {
    private static final Integer THOUSAND = 1000;
    private final Integer money;

    public Money(Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(Integer money) {
        validateZero(money);
        validateDivide(money);
    }

    private void validateZero(Integer money) {
        if (money == 0) {
            throw new InvalidInputMoneyZeroException();
        }
    }

    private void validateDivide(Integer money) {
        if(money % THOUSAND != 0) {
            throw new InvalidInputMoneyDivideException();
        }
    }
}
