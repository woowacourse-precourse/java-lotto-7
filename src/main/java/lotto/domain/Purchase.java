package lotto.domain;

import static lotto.config.ErrorMessageConstant.PURCHASE_REMINDER_MESSAGE;
import static lotto.config.ErrorMessageConstant.PURCHASE_TOO_LOW_MESSAGE;

import lotto.config.GameConstant;

public class Purchase implements Money {
    private long money;

    public Purchase(long money) {
        validatePurchase(money);
        this.money = money;
    }

    @Override
    public long getMoney() {
        return money;
    }

    private static void validatePurchase(long money) {
        if (money < GameConstant.PRICE_OF_LOTTO) {
            throw new IllegalArgumentException(PURCHASE_TOO_LOW_MESSAGE);
        }

        if (money % GameConstant.PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(PURCHASE_REMINDER_MESSAGE);
        }
    }
}