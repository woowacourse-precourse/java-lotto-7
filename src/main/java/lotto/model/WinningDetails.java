package lotto.model;

import java.util.EnumSet;

public enum WinningDetails {

    NO_WIN(new Rank(0, false), "0", 0),
    FIFTH_PRIZE(new Rank(3, false), "5,000", 0),
    FOURTH_PRIZE(new Rank(4, false), "50,000", 0),
    THIRD_PRIZE(new Rank(5, false), "1,500,000", 0),
    SECOND_PRIZE(new Rank(5, true), "30,000,000", 0),
    FIRST_PRIZE(new Rank(6, false), "2,000,000,000", 0);

    private final Rank rank;
    private final String winningPrize;
    private int matchedLottoCount;


    public String getWinningPrize() {
        return winningPrize;
    }

    public int getMatchLottoCount() {
        return matchedLottoCount;
    }

    public int getSameNumberCount() {
        return rank.matchCount();
    }

    public boolean getMatchBonusNumber() {
        return rank.isBonusMatched();
    }


    WinningDetails(Rank rank, String winningPrize, int matchedLottoCount) {
        this.rank = rank;
        this.winningPrize = winningPrize;
        this.matchedLottoCount = matchedLottoCount;
    }

    public static EnumSet<WinningDetails> getWinningDetails() {
        EnumSet<WinningDetails> noWin = EnumSet.of(WinningDetails.NO_WIN);
        return EnumSet.complementOf(noWin);
    }

    public static void implementMatchLottoCount(int sameNumberCount, boolean matchBonusNumber) {
        WinningDetails winningDetails = getWinningRank(sameNumberCount, matchBonusNumber);
        winningDetails.matchedLottoCount++;
    }

    private static WinningDetails getWinningRank(int sameNumberCount, boolean matchBonusNumber) {
        for (WinningDetails winningDetail : WinningDetails.values()) {
            if (winningDetail.rank.matches(sameNumberCount, matchBonusNumber)) {
                return winningDetail;
            }
        }
        return WinningDetails.NO_WIN;
    }

}
