package lotto.domain;

import static lotto.config.ErrorMessageConstant.PURCHASE_REMINDER_MESSAGE;
import static lotto.config.ErrorMessageConstant.PURCHASE_TOO_LOW_MESSAGE;
import static lotto.config.GameConstant.PRICE_OF_LOTTO;
import static lotto.util.Parser.parseToInteger;

public class Money {
    private int money;

    public Money(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return this.money;
    }

    private void validateMoney(String money) {
        int parsedMoney = parseToInteger(money);

        if (parsedMoney < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException(PURCHASE_TOO_LOW_MESSAGE);
        }

        if (parsedMoney % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(PURCHASE_REMINDER_MESSAGE);
        }
    }
}
