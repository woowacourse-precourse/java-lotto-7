package lotto.vo;

import static lotto.constants.Constants.MAX_USER_MONEY;
import static lotto.constants.Constants.MIN_USER_MONEY;
import static lotto.constants.Constants.MONEY_UNIT;
import static lotto.constants.Constants.ZERO;

import lotto.constants.ErrorMessages;

public record Money(int money) {

    public Money {
        validate(money);
    }

    private void validate(int money) {
        validateRange(money);
        validateUnit(money);
    }

    private void validateRange(int money) {
        if (underMinMoney(money) || overMaxMoney(money)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MONEY_RANGE.getMessage());
        }
    }

    private void validateUnit(int money) {
        if (hasInvalidUnit(money)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MONEY_UNIT.getMessage());
        }
    }

    private boolean hasInvalidUnit(int money) {
        return money % MONEY_UNIT != ZERO;
    }

    private boolean overMaxMoney(int money) {
        return money > MAX_USER_MONEY;

    }

    private boolean underMinMoney(int money) {
        return money <= MIN_USER_MONEY;
    }
}
