package lotto.domain;

public enum LottoRank {
    SIX_MATCH(6, false, 200000000L),
    FIVE_MATCH_BONUS(5, true, 30000000L),
    FIVE_MATCH(5, false, 1500000L),
    FOUR_MATCH(4, false, 50000L),
    THREE_MATCH(3, false, 5000L),
    MISS(0, false, 0L);

    private final int matchCount;
    private final boolean isBonusInLotto;
    private final long prize;

    LottoRank(int matchCount, boolean isBonusInLotto, long prize) {
        this.matchCount = matchCount;
        this.isBonusInLotto = isBonusInLotto;
        this.prize = prize;
    }

    public static LottoRank findRankByMatching(int matchCount, boolean hasBonusNumber) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchCount && (matchCount != 5 || rank.isBonusInLotto == hasBonusNumber)) {
                return rank;
            }
        }
        return LottoRank.MISS;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
