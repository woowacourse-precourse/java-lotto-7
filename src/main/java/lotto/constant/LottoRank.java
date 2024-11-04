package lotto.constant;

public enum LottoRank {
    FIRST(1, 6, 2000000000, false),
    SECOND(2, 5, 30000000, true),
    THIRD(3, 5, 1500000, false),
    FOURTH(4, 4, 50000, false),
    FIFTH(5, 3, 5000, false),
    LOOSE(-1, -1, 0, false);

    private final int value;
    private final int matchCount;
    private final int prize;
    private final boolean isBonusIncluded;

    LottoRank(int value, int matchCount, int prize, boolean isBonusIncluded) {
        this.value = value;
        this.matchCount = matchCount;
        this.prize = prize;
        this.isBonusIncluded = isBonusIncluded;
    }

    public int getRankValue() {
        return this.value;
    }

    public static LottoRank getRank(int matchCount, boolean isBonusIncluded) {
        if (matchCount == LottoRank.FIRST.matchCount) return LottoRank.FIRST;
        if (matchCount == LottoRank.SECOND.matchCount && isBonusIncluded) return LottoRank.SECOND;
        if (matchCount == LottoRank.THIRD.matchCount) return LottoRank.THIRD;
        if (matchCount == LottoRank.FOURTH.matchCount) return LottoRank.FOURTH;
        if (matchCount == LottoRank.FIFTH.matchCount) return LottoRank.FIFTH;
        return LottoRank.LOOSE;
    }
}
