package lotto.validation;

import static lotto.model.Money.MONEY_UNIT;

import lotto.exception.ExceptionMessage;

public class MoneyValidator {
    private static final int VALIDATE_VALUE = 0;
    private static final int POSITIVE_NUMBER = 1;

    public static void validateMoney(int money) {
        validatePositiveNumber(money);
        validateMoneyUnit(money);
    }

    private static void validatePositiveNumber(int money) {
        if (money < POSITIVE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_INPUT.getMessage());
        }
    }

    private static void validateMoneyUnit(int money) {
        if (money % MONEY_UNIT != VALIDATE_VALUE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_INPUT.getMessage());
        }
    }
}
