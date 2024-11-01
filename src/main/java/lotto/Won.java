package lotto;

public class Won {
    private final int amount;

    public Won(int amount) {
        this.amount = amount;
    }

    public boolean isLessThan(Won value) {
        return value.amount < this.amount;
    }

    public boolean hasChange(Won value) {
        return this.amount % value.amount != 0;
    }

    @Override
    public String toString() {
        return String.format("%d원", amount);
    }
}
