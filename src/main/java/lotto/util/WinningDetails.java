package lotto.util;

public enum WinningDetails {

    NO_WIN(0, false, "0", 0),
    FIFTH_PRIZE(3, false, "5,000", 0),
    FOURTH_PRIZE(4, false, "50,000", 0),
    THIRD_PRIZE(5, false, "1,500,000", 0),
    SECOND_PRIZE(5, true, "30,000,000", 0),
    FIRST_PRIZE(6, false, "2,000,000,000", 0);


    private int sameNumberCount;
    private boolean matchBonusNumber;

    private String winningPrize;
    private int matchedLottoCount;


    WinningDetails(int sameNumberCount, boolean matchBonusNumber, String winningPrize, int matchedLottoCount) {
        this.sameNumberCount = sameNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.winningPrize = winningPrize;
        this.matchedLottoCount = matchedLottoCount;
    }


    public static void addMatchLottoCount(int sameNumberCount, boolean matchBonusNumber) {
        WinningDetails rank = getLottoRankByLottoNumbers(sameNumberCount, matchBonusNumber);
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


    private static WinningDetails getLottoRankByLottoNumbers(int sameNumberCount, boolean matchBonusNumber) {
        if (sameNumberCount == 5 && matchBonusNumber) {
            return WinningDetails.SECOND_PRIZE;
        }

        for (WinningDetails rank : WinningDetails.values()) {
            if (rank.sameNumberCount == sameNumberCount && !rank.matchBonusNumber) {
                return rank;
            }
        }
        return WinningDetails.NO_WIN;
    }

}
