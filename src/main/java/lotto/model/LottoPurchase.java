package lotto.model;

import static lotto.ExceptionMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION;

public class LottoPurchase {
    private long lottoPurchaseCount;

    public void calculateLottoPurchaseCount(long purchaseAmount) {
        validatePurchaseAmountDivisibleBy1000(purchaseAmount);
        lottoPurchaseCount = purchaseAmount / 1000;
    }

    public long getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }

    public long getPurchaseAmount() {
        return lottoPurchaseCount * 1000;
    }

    private void validatePurchaseAmountDivisibleBy1000(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION.message());
        }
    }
}
