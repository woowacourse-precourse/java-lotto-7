package lotto.domain;

import static lotto.util.ErrorResponse.INVALID_MONEY;
import static lotto.util.ErrorResponse.INVALID_MONEY_BOUND;
import static lotto.util.ErrorResponse.INVALID_MONEY_UNIT;

public class Money {
    private final int value;

    private Money(String input) {
        this.value = convertStrToInt(input);
        validate(value);
    }

    public static Money from(String input) {
        return new Money(input);
    }

    private int convertStrToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        }
    }

    private void validate(int money) {
        validateMoneyRange(money);
        validateDivisible(money);
    }

    private void validateMoneyRange(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(INVALID_MONEY_BOUND.getMessage());
        }
    }

    private void validateDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
