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

    public static Prize getRankByMatchCount(int count, boolean bonus_matched) {
        if (count == 6) return FIRST;
        if (count == 5 && bonus_matched) return SECOND;
        if (count == 5) return THIRD;
        if (count == 4) return FOURTH;
        if (count == 3) return FIFTH;
        return null;
    }
}
