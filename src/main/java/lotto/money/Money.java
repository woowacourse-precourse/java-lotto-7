package lotto.money;

import java.util.Objects;

public class Money {
    private static final int EMPTY_MONEY = 0;

    public final int amount;

    public Money(int amount) {
        if(isMinusMoney(amount))
            throw new IllegalArgumentException("돈은 음수가 불가능합니다.");
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private boolean isMinusMoney(int amount) {
        return amount < EMPTY_MONEY;
    }
}
