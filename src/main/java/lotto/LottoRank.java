package lotto;

public enum LottoRank {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    ;

    private final int winnings;
    private final int matchCount;

    LottoRank(int winnings, int matchCount) {
        this.winnings = winnings;
        this.matchCount = matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank getRank(int matchCount, boolean isMatchBonus){
        if (matchCount == LottoRank.FIRST.getMatchCount())
            return LottoRank.FIRST;
        if (matchCount == LottoRank.SECOND.getMatchCount() && isMatchBonus)
            return LottoRank.SECOND;
        if (matchCount == LottoRank.THIRD.getMatchCount())
            return LottoRank.THIRD;
        if (matchCount == LottoRank.FOURTH.getMatchCount())
            return LottoRank.FOURTH;
        if (matchCount == LottoRank.FIFTH.getMatchCount())
            return LottoRank.FIFTH;
        return null;
    }
}
