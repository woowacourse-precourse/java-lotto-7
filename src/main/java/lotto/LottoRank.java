package lotto;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000, 5),
    SECOND(5, true, 30_000_000, 4),
    THIRD(5, false, 1_500_000, 3),
    FOURTH(4, false, 50_000, 2),
    FIFTH(3, false, 5_000, 1),
    NONE(0, false, 0, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final long prize;
    private final int index;

    LottoRank(int matchCount, boolean matchBonus, long prize, int index) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.index = index;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public long getPrize() {
        return prize;
    }

    public int getIndex() {
        return index;
    }

    public boolean isWinningRank() {
        return this != NONE;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6)
            return FIRST;
        if (matchCount == 5 && matchBonus)
            return SECOND;
        if (matchCount == 5)
            return THIRD;
        if (matchCount == 4)
            return FOURTH;
        if (matchCount == 3)
            return FIFTH;
        return NONE;
    }
}
