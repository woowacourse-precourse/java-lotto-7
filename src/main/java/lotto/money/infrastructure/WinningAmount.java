package lotto.money.infrastructure;

import lotto.money.domain.Money;
import lotto.util.Convertor;

public class WinningAmount implements Money {
    private final long amount;
    private WinningAmount(long amount) {
        this.amount = amount;
    }
    public static WinningAmount of(String input) {
        long amount = Convertor.stringToLong(input);
        return new WinningAmount(amount);
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
