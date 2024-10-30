package lotto.domain;

import lotto.constants.ExceptionMessage;

public class LottoPurchase {
    private static final int LOTTO_PER_PRICE = 1000;

    private final int amount;

    public LottoPurchase(int amount) {
        validatePositive(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    private static void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MULTIPLE_HUNDRED);
        }
    }

    private static void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITIVE_NUMBER);
        }
    }

    public int getPurchaseAmount() {
        return amount / LOTTO_PER_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
