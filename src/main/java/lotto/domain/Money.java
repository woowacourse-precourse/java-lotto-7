package lotto.domain;

import lotto.message.ExceptionMessage;

public class Money {

    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        validateUnit(money);
        validateNotNegative(money);
    }

    private void validateUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT);
        }
    }

    private void validateNotNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER);
        }
    }

    public int getPurchasableLottoCount(int money) {
        return money / 1000;
    }
}