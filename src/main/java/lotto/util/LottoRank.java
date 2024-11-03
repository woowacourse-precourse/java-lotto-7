package lotto.util;

public enum LottoRank {

    NONE(0, false, "0", 0),
    FIFTH(3, false, "5,000", 0),
    FOURTH(4, false, "50,000", 0),
    THIRD(5, false, "1,500,000", 0),
    SECOND(5, true, "30,000,000", 0),
    FIRST(6, false, "2,000,000,000", 0);


    private int sameNumberCount;
    private boolean matchBonusNumber;

    private String winningPrize;
    private int matchedLottoCount;


    LottoRank(int sameNumberCount, boolean matchBonusNumber, String winningPrize, int matchedLottoCount) {
        this.sameNumberCount = sameNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.winningPrize = winningPrize;
        this.matchedLottoCount = matchedLottoCount;
    }


    public static void addMatchLottoCount(int sameNumberCount, boolean matchBonusNumber) {
        LottoRank rank = getLottoRankByLottoNumbers(sameNumberCount, matchBonusNumber);
        rank.matchedLottoCount++;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getMatchLottoCount() {
        return matchedLottoCount;
    }

    public String getWinningPrize() {
        return winningPrize;
    }

    public boolean getMatchBonusNumber() {
        return matchBonusNumber;
    }


    private static LottoRank getLottoRankByLottoNumbers(int sameNumberCount, boolean matchBonusNumber) {
        if (sameNumberCount == 5 && matchBonusNumber) {
            return LottoRank.SECOND;
        }

        for (LottoRank rank : LottoRank.values()) {
            if (rank.sameNumberCount == sameNumberCount && !rank.matchBonusNumber) {
                return rank;
            }
        }
        return LottoRank.NONE;
    }

}
