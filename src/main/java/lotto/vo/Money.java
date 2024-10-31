package lotto.vo;

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
        if (isNegative(money) || isOver100kWon(money)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MONEY_RANGE.getMessage());
        }
    }

    private void validateUnit(int money) {
        if (hasInvalidUnit(money)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MONEY_UNIT.getMessage());
        }
    }

    private boolean hasInvalidUnit(int money) {
        return money % 1_000 != 0;
    }

    private boolean isOver100kWon(int money) {
        return money > 100_000;

    }

    private boolean isNegative(int money) {
        return money <= 0;
    }


}
