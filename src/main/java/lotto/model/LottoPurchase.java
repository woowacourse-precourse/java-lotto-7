package lotto.model;

import static lotto.constant.Constants.LOTTO_PURCHASE_PRICE;
import static lotto.constant.Constants.MINIMUM_LOTTO_AMOUNT;
import static lotto.constant.Constants.NO_REMAINDER;

import lotto.exception.PurchaseException;

public class LottoPurchase {

    public LottoPurchase(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= MINIMUM_LOTTO_AMOUNT) {
            throw new IllegalArgumentException(PurchaseException.NON_POSITIVE_AMOUNT.getMessage());
        }
        if (amount % LOTTO_PURCHASE_PRICE != NO_REMAINDER) {
            throw new IllegalArgumentException(PurchaseException.INVALID_UNIT.getMessage());
        }
    }
}