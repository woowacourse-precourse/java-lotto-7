package lotto;

public enum LottoRank {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3)
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
        if (matchCount == 5 && !isMatchBonus)
            return THIRD;
        for (LottoRank lottoRank : LottoRank.values()){
            if (lottoRank.getMatchCount() == matchCount)
                return lottoRank;
        }
        return null;
    }
}
