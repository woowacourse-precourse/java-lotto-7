package lotto;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matched_count;
    private final int prize;

    Prize(int matched_count, int prize) {
        this.matched_count = matched_count;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return matched_count;
    }

    public int getPrize() {
        return prize;
    }
}
