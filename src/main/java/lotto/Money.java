package lotto;

import lotto.constant.NumberType;

import static lotto.constant.ErrorMessage.PURCHASE_PRICE_ERROR;

public class Money {
    private Integer amount;

    public Money(Integer amount) {
        validMoney(amount);
        this.amount = amount;
    }

    public void minus(Money money) {
        this.amount -= money.amount;
    }

    public Integer getAmount() {
        return amount;
    }

    private void validMoney(Integer amount) {
        if (!isFitPurchasePrice(amount)) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ERROR.getMessage());
        }
    }

    private boolean isFitPurchasePrice(Integer amount) {
        return amount % NumberType.LOTTO_PRICE.getPrice() == 0;
    }
}
