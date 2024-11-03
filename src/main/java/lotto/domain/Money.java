package lotto.domain;

import lotto.exception.money.DivideMoneyException;
import lotto.exception.money.MaximunMoneyException;
import lotto.exception.money.ZeroMoneyException;
import lotto.util.Limit;

public class Money {
    public static final int ZERO = 0;
    public static final int PURCHASE_MONEY_MAX_RANGE = 100_000;

    private final int amount;

    private Money(int amount) {
        validateZero(amount);
        validateMaximum(amount);
        validateDivide(amount);
        this.amount = amount;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    private void validateDivide(int amount) {
        if (amount % Limit.PURCHASE_MONEY_UNIT != ZERO) {
            throw new DivideMoneyException();
        }
    }

    private void validateZero(int amount) {
        if (amount == ZERO) {
            throw new ZeroMoneyException();
        }
    }

    private void validateMaximum(int amount) {
        if (amount > PURCHASE_MONEY_MAX_RANGE) {
            throw new MaximunMoneyException();
        }
    }

    public int getPurchaseQuantity() {
        return amount / Limit.PURCHASE_MONEY_UNIT;
    }
}
