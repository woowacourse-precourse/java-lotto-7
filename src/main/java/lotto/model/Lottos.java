package lotto.model;

import static lotto.ExceptionMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION;

public class Lottos {
    private long lottoPurchaseCount;

    public void calculateLottoPurchaseCount(String purchaseAmount) {
        long amount = Long.parseLong(purchaseAmount);
        validatePurchaseAmountDivisibleBy1000(amount);
        lottoPurchaseCount = amount / 1000;
    }

    private void validatePurchaseAmountDivisibleBy1000(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION.message());
        }
    }

    public long getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }
}
