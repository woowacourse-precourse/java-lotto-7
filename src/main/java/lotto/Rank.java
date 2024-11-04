package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private final boolean isRequireBonus;

    Rank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    Rank(int matchCount, int prize, boolean isRequireBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isRequireBonus = isRequireBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isRequireBonus() {
        return isRequireBonus;
    }

    public static Rank getRank(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && (!rank.isRequireBonus || matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }
}