package lotto.domain;

import lotto.Validator.AmountValidator;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        AmountValidator.validateAmount(amount);
        this.amount = amount;
    }

    public int calculateNumberOfLottos() {
        return amount / LOTTO_PRICE;
    }
}
