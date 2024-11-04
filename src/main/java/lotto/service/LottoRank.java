package lotto.service;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000, "1등"),
    SECOND(5, true, 30_000_000, "2등"),
    THIRD(5, false, 1_500_000, "3등"),
    FOURTH(4, false, 50_000, "4등"),
    FIFTH(3, false, 5_000, "5등"),
    NONE(0, false, 0, "당첨된 번호가 없습니다.");

    private final int matchCount;
    private final boolean bonusMatched;
    private final int prize;
    private final String rankName;

    LottoRank(int matchCount, boolean bonusMatched, int prize, String rankName) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
        this.rankName = rankName;
    }

    public int getPrize() {
        return prize;
    }

    public String getRankName() {
        return rankName;
    }

    public static LottoRank determineRank(int matchCount, boolean isBonusMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchCount && rank.bonusMatched == isBonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}
