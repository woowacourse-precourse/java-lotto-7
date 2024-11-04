package lotto.domain;

public enum LottoRank {
    MISS(0, false, 0L, "꽝"),
    THREE_MATCH(3, false, 5000L, "3개 일치"),
    FOUR_MATCH(4, false, 50000L, "4개 일치"),
    FIVE_MATCH(5, false, 1500000L, "5개 일치"),
    FIVE_MATCH_BONUS(5, true, 30000000L, "5개 일치, 보너스 볼 일치"),
    SIX_MATCH(6, false, 2000000000L, "6개 일치");

    private final int matchCount;
    private final boolean isBonusInLotto;
    private final long prize;
    private final String description;

    LottoRank(int matchCount, boolean isBonusInLotto, long prize, String description) {
        this.matchCount = matchCount;
        this.isBonusInLotto = isBonusInLotto;
        this.prize = prize;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

}
