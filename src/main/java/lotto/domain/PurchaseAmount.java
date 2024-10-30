package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {
    private static final double UNIT = 1000.0;
    private static final double MAX_PURCHASE_AMOUNT = 100000000.0;
    private final double purchaseAmount;

    public PurchaseAmount(double purchaseAmount) {
        validateUnit(purchaseAmount);
        validateMax(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateMax(double purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MAX_ERROR_MESSAGE);
        }
    }

    private void validateUnit(double purchaseAmount) {
        if(purchaseAmount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNIT_DIVISIBLE_ERROR_MESSAGE);
        }
    }
}
