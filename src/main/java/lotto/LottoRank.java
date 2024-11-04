package lotto;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchedCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchedCount, boolean matchBonus, int prize) {
        this.matchedCount = matchedCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public static LottoRank getRank(int matchedCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchedCount == matchedCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MISS;
    }
}

