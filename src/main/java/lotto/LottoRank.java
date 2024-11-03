package lotto;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank getLottoRank(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST.matchCount) return FIRST;
        if (matchCount == SECOND.matchCount && matchBonus) return SECOND;
        if (matchCount == THIRD.matchCount) return THIRD;
        if (matchCount == FOURTH.matchCount) return FOURTH;
        if (matchCount == FIFTH.matchCount) return FIFTH;
        return null;
    }
}
