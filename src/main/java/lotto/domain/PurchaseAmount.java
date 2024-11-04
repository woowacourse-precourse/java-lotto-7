package lotto.domain;

import static lotto.common.Constants.LOTTO_PRICE;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public int calculateLottoCount() {
        return this.amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
