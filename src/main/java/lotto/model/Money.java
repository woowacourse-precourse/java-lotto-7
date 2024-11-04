package lotto.model;

import lotto.exceptions.ArgumentException;
import lotto.exceptions.StateException;

public class Money {
    static final int LOTTO_PRICE = 1000;

    private final int sum;

    private Money(final int sum) {
        validateRange(sum);
        validate(sum);
        this.sum = sum;
    }

    public static Money createMoney(final int sum) {
        return new Money(sum);
    }

    private void validate(final int sum) throws ArgumentException {
        if (sum % LOTTO_PRICE != 0) {
            throw ArgumentException.INVALID_MONEY_UNIT;
        }
    }

    int getSum() {
        return sum;
    }

    private void validateRange(int money) {
        if (money > 0) {
            throw ArgumentException.INVALID_MONEY_RANGE;
        }
    }
}
