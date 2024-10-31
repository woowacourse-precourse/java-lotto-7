package lotto.model;

import lotto.exception.ExceptionMessage;

public class Money {
    private static final int MONEY_UNIT = 1000;
    private static final int VALIDATE_VALUE = 0;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money % MONEY_UNIT != VALIDATE_VALUE){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_INPUT.getMessage());
        }
    }
}
