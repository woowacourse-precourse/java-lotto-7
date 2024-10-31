package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean needToCheckBonus;
    private final int prize;

    Rank(int matchCount, boolean needToCheckBonus, int prize) {
        this.matchCount = matchCount;
        this.needToCheckBonus = needToCheckBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getNeedToCheckBonus() {
        return needToCheckBonus;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && (rank.needToCheckBonus == hasBonus)) {
                return rank;
            }
        }
        return null;
    }
}
