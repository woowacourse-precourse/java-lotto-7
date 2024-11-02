package model;

import validation.Validation;

public class Amount {

    private final int purchaseAmount;

    public Amount(int purchaseAmount) {
        Validation.overInput(purchaseAmount);
        Validation.divideByLottoValue(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }


}
