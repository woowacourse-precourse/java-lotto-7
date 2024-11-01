package lotto.money.infrastructure;

import lotto.money.domain.Money;

public class WinningAmount implements Money {
    private final long amount;
    public WinningAmount(long amount) {
        this.amount = amount;
    }
    @Override
    public long getMoney() {
        return amount;
    }
    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
