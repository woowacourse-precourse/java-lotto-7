package lotto.domain;

import lotto.exception.DivideMoneyException;

public class Money {
    private final int amount;

    private Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new DivideMoneyException();
        }
    }
}
