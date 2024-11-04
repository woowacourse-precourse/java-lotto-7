package lotto.model;

import lotto.enums.ErrorMessage;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int purchasingMoney;

    public Money(int purchasingMoney) {
        validateAmount(purchasingMoney);
        this.purchasingMoney = purchasingMoney;
    }

    private void validateAmount(int purchasingAmount) {
        if (purchasingAmount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(
                "[ERROR] " + ErrorMessage.EXCEED_MONEY_AMOUNT.getMessage());
        }
        if (purchasingAmount <= 0 || purchasingAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                "[ERROR] " + ErrorMessage.INVALID_PURCHASING_AMOUNT.getMessage());
        }
    }

    public int getPurchasingMoney() {
        return purchasingMoney;
    }

    public int getLottoCount() {
        return purchasingMoney / LOTTO_PRICE;
    }
}
