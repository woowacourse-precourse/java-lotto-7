package lotto.model.winnerRank;

public class WinnerRankDeterminer {
    public WinnerRank determine(int matchingAmount, boolean matchesBonusNumber) {
        for (WinnerRank winnerRank : WinnerRank.values()) {
            if (winnerRank.getMatchingAmount() == matchingAmount) {
                return fromMatchingAmountAndBonusNumber(winnerRank, matchingAmount, matchesBonusNumber);
            }
        }
        return WinnerRank.FAIL;
    }

    private WinnerRank fromMatchingAmountAndBonusNumber(WinnerRank winnerRank, int matchingAmount,
                                                               boolean matchesBonusNumber) {
        if (winnerRank.isWithBonusNumber()) {
            if (matchesBonusNumber) {
                return winnerRank;
            }
            return WinnerRank.findByRank(winnerRank.getRank() + 1);
        }
        return winnerRank;
    }
}
