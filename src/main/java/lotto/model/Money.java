package lotto.model;

import lotto.message.InputErrorMessage;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Money(Integer amount) {
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
