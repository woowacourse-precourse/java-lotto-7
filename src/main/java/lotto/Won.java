package lotto;

public class Won {
    private final int amount;

    public Won(int amount) {
        this.amount = amount;
    }

    public int value() {
        return this.amount;
    }

    @Override
    public String toString() {
        return String.format("%d원", amount);
    }

    public boolean isLessThan(Won won) {
        return won.amount < this.amount;
    }
}
