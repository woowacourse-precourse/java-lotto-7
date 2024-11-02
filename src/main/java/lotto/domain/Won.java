package lotto.domain;

import java.util.Objects;

public class Won {
    private final long amount;

    public Won(long amount) {
        this.amount = amount;
    }

    public boolean isLessThan(Won value) {
        return value.amount < this.amount;
    }

    public boolean hasChange(Won value) {
        return this.amount % value.amount != 0;
    }

    public double divide(Won value) {
        return this.amount / (double) value.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Won won = (Won) o;
        return amount == won.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.format("%d원", amount);
    }
}
