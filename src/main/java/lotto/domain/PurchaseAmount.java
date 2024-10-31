package lotto.domain;

import lotto.constant.ExceptionMessage;

public class PurchaseAmount {

    private static final int DIGIT = 1_000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validateMinimumAmount(amount);
        this.amount = amount;
    }

    private void validateMinimumAmount(int value) {
        if (value < DIGIT) {
            ExceptionMessage message = ExceptionMessage.MINIMUM_AMOUNT;
            throw new IllegalArgumentException(message.getMessage());
        }
    }
}
