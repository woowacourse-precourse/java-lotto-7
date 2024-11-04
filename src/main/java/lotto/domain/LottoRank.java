package lotto.domain;

public enum LottoRank {
    SIX_MATCH(6, false, "200000000"),
    FIVE_MATCH_BONUS(5, true, "30000000"),
    FIVE_MATCH(5, false, "1500000"),
    FOUR_MATCH(4, false, "50000"),
    THREE_MATCH(3, false, "5000"),
    MISS(0, false, "0");

    private final int matchCount;
    private final boolean isBonusInLotto;
    private final String prize;

    LottoRank(int matchCount, boolean isBonusInLotto, String prize) {
        this.matchCount = matchCount;
        this.isBonusInLotto = isBonusInLotto;
        this.prize = prize;
    }

    public static LottoRank findRankByMatching(int matchCount, boolean hasBonusNumber) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchCount && rank.isBonusInLotto == hasBonusNumber) {
                return rank;
            }
        }
        return LottoRank.MISS;
    }


}
