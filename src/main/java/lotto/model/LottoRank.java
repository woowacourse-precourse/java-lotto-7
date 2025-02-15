package lotto.model;

public enum LottoRank {
    NONE(0, false, 0, ""),
    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    ;

    private final int matchCount;
    private final boolean matchBonusNumber;
    private final int prize;
    private final String matchInfo;

    LottoRank(int matchCount, boolean matchBonusNumber, int prize, String matchInfo) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prize = prize;
        this.matchInfo = matchInfo;
    }

    public int getPrize() {
        return prize;
    }

    public String getMatchInfo() {
        return matchInfo;
    }

    public static LottoRank getRank(int matchCount, boolean matchBonusNumber) {
        for (LottoRank rank : LottoRank.values()) {
            if(rank.matchCount == matchCount && rank.matchBonusNumber == matchBonusNumber) {
                return rank;
            }
        }
        return LottoRank.NONE;
    }

}
