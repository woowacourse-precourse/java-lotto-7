package lotto.model;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidPurchaseUnitException;

import static lotto.constant.Constants.LOTTO_PRICE;

public class Balance {
    private final int money;
    private final int ticket;

    public Balance(int money) {
        validate(money);
        this.money = money;
        this.ticket = this.money / LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE)
            throw new InvalidPurchaseAmountException();
        else if (money % LOTTO_PRICE != 0)
            throw new InvalidPurchaseUnitException();
    }

    public int getMoney() {
        return this.money;
    }

    public int getTicket() {
        return this.ticket;
    }
}
