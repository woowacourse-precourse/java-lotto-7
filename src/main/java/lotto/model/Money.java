package lotto.model;

import lotto.enums.ErrorMessage;

public class Money {
    int purchaseAmount;

    public Money(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.toString());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
