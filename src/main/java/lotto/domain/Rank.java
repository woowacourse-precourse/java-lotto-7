package lotto.domain;

public enum Rank {
    ONE(2_000_000_000),
    TWO(30_000_000),
    THREE(1_500_000),
    FOUR(50_000),
    FIVE(5_000);

    private final int amount;

    private Rank(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
