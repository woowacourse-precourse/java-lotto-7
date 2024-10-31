package lotto.domain;

import lotto.util.Error;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateNonZero(amount);
        validateDivisibility(amount);
        this.amount = amount;
    }

    private void validateNonZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(Error.MONEY_ZERO_ERROR.message());
        }
    }

    private void validateDivisibility(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Error.MONEY_DIVIDE_ERROR.message());
        }
    }

    public int calculateNumberOfTickets() {
        return amount / 1000;
    }
}
