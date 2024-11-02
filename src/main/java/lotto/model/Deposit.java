package lotto.model;

import static lotto.utils.Error.PURCHASE_AMOUNT_NOT_DIVISIBLE;
import static lotto.utils.Error.PURCHASE_AMOUNT_OUT_OF_RANGE;

public class Deposit {
    private static final int PURCHASE_UNIT = 1_000;
    private static final int MIN_PURCHASE_AMOUNT = 1_000;
    private static final int MAX_PURCHASE_AMOUNT = 1_000_000;
    private final int purchaseAmount;

    public Deposit(int purchaseAmount) {
        validateInRange(purchaseAmount);
        validatePurchaseUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getNumberOfLottoes() {
        return this.purchaseAmount / PURCHASE_UNIT;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    private void validateInRange(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT || MAX_PURCHASE_AMOUNT < purchaseAmount) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_OUT_OF_RANGE.getDescription());
        }
    }

    private void validatePurchaseUnit(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE.getDescription());
        }
    }
}
