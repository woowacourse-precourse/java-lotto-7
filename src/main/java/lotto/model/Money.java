package lotto.model;

import lotto.message.InputErrorMessage;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
