package lotto.model;

import message.ErrorMessage;

public class AttemptCount {
    private static final int LOTTO_PRICE = 1000;

    private final int attemptCount;

    private AttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public static AttemptCount from(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int attemptCount = calculateAttemptCount(purchaseAmount);
        return new AttemptCount(attemptCount);
    }

    private static int calculateAttemptCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (isInvalidPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_UNIT.message());
        }
    }

    private static boolean isInvalidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != 0;
    }

    public int getCount() {
        return attemptCount;
    }
}
