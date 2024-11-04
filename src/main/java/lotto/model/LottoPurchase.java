package lotto.model;

import lotto.validator.LottoPurchaseValidator;

public class LottoPurchase {
    private final int amount;

    public LottoPurchase(int purchaseAmount) {
        LottoPurchaseValidator.validateAmount(purchaseAmount);
        this.amount = purchaseAmount;
    }

    public int getAmount() {
        return amount;
    }
}