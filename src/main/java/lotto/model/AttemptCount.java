package lotto.model;

import message.ErrorMessage;

public class AttemptCount {
    private static final int LOTTO_PRICE = 1000;

    private final int attemptCount;

    public AttemptCount(int purchaseAmount) {
        this.attemptCount = calculateAttemptCount(purchaseAmount);
    }

    private int calculateAttemptCount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (isInvalidPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_UNIT.message());
        }
    }

    private boolean isInvalidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != 0;
    }

    public int getCount() {
        return attemptCount;
    }
}
