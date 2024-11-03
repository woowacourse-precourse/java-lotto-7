package lotto;

public enum LottoPrize {

    FIRST_PRIZE(2000000000, 6),
    SECOND_PRIZE(30000000, 5, true),
    THIRD_PRIZE(1500000, 5, false),
    FOURTH_PRIZE(50000, 4),
    FIFTH_PRIZE(5000, 3);

    private final long amount;
    private final int matchCount;
    private final boolean hasBonus;

    LottoPrize(int amount, int matchCount) {
        this(amount, matchCount, false);
    }

    LottoPrize(int amount, int matchCount, boolean hasBonus) {
        this.amount = amount;
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public long getAmount() {
        return this.amount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean hasBonus() {
        return this.hasBonus;
    }
}
