package lotto.domain;

import lotto.exception.DivideMoneyException;
import lotto.exception.MaximunMoneyException;
import lotto.exception.ZeroMoneyException;

public class Money {
    private final int amount;

    private Money(int amount) {
        validateDivide(amount);
        validateZero(amount);
        validateMaximum(amount);
        this.amount = amount;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    private void validateDivide(int amount) {
        if (amount % 1000 != 0) {
            throw new DivideMoneyException();
        }
    }

    private void validateZero(int amount) {
        if (amount == 0) {
            throw new ZeroMoneyException();
        }
    }

    private void validateMaximum(int amount) {
        if (amount > 100_000) {
            throw new MaximunMoneyException();
        }
    }

    public int getPurchaseQuantity() {
        return amount / 1000;
    }
}
