package lotto.util.calculator;

import static lotto.error.ThrowException.throwIllegalArgumentException;

import lotto.error.Error;

public class PurchasableCalculator {

    public int calculatePurchasableCount(int purchaseAmount, int unitPrice) {
        int purchasableCount = purchaseAmount / unitPrice;
        validatePositiveCount(purchasableCount);
        return purchasableCount;
    }

    private void validatePositiveCount(int purchasableCount) {
        boolean validateCount = purchasableCount <= 0;
        String errorFormat = Error.CANNOT_PURCHASE_ANY_PRODUCT.getMessage();
        throwIllegalArgumentException(validateCount, errorFormat);
    }

}
