package lotto.model;

import static lotto.constant.ErrorMessage.NEGATIVE_MONEY;

public class Money {
    private static final double TO_PERCENTAGE = 100.0;

    protected final int amount;

    public Money(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(final int amount) {
        validateNotNegative(amount);
    }

    private void validateNotNegative(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY.getMessage());
        }
    }

    public double getEarningsRate(Money earnings) {
        return TO_PERCENTAGE * earnings.amount / this.amount;
    }

    public int toInteger() {
        return amount;
    }
}
