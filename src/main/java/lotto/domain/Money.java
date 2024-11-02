package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class Money {
    private static final int UNIT_PRICE = 1_000;
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(String input) {
        int money = stringToInt(input);
        validate(money);
        return new Money(money);
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw InputException.from(ErrorMessage.MONEY_HAS_CHARACTER);
        }
    }

    private static void validate(int money) {
        validateNegativeNumber(money);
        validateLessThanUnitPrice(money);
        validateNotDividedUnitPrice(money);
    }

    private static void validateNegativeNumber(int money) {
        if (money < 0) {
            throw InputException.from(ErrorMessage.MONEY_IS_NEGATIVE_NUMBER);
        }
    }

    private static void validateLessThanUnitPrice(int money) {
        if (money < UNIT_PRICE) {
            throw InputException.from(ErrorMessage.MONEY_IS_LESS_THAN_UNIT_PRICE);
        }
    }

    private static void validateNotDividedUnitPrice(int money) {
        if (money % UNIT_PRICE != 0) {
            throw InputException.from(ErrorMessage.MONEY_IS_NOT_DIVIDED_BY_UNIT_PRICE);
        }
    }
}
