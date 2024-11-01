package lotto.validation;

import static lotto.model.Money.MONEY_UNIT;

import lotto.exception.ExceptionMessage;

public class MoneyValidator {
    private static final int VALIDATE_VALUE = 0;

    public static void validateMoney(int money) {
        if (money % MONEY_UNIT != VALIDATE_VALUE){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_INPUT.getMessage());
        }
    }
}
