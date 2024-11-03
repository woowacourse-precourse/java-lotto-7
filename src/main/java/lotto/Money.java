package lotto;

import lotto.constant.NumberType;

import static lotto.constant.ErrorMessage.PURCHASE_PRICE_ERROR;

public class Money {
    private long amount;

    public Money(long amount) {
        validMoney(amount);
        this.amount = amount;
    }

    public void minus(Money money) {
        this.amount -= money.amount;
    }

    public long getAmount() {
        return amount;
    }

    private void validMoney(long amount) {
        if (!isFitPurchasePrice(amount)) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ERROR.getMessage());
        }
    }

    private boolean isFitPurchasePrice(long amount) {
        return amount % NumberType.LOTTO_PRICE.getPrice() == 0;
    }
}
