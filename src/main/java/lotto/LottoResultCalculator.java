package lotto;

public class LottoResultCalculator {

    private final static int BONUS_NUMBER_MATCH_COUNT = 5;
    private WinningNumber winningNumber;


    public LottoResultCalculator(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public Rank calculateRanking(Lotto userLotto) {
        int matchCount = winningNumber.findMatchCount(userLotto);
        boolean matchedBonusNumber = matchCount == BONUS_NUMBER_MATCH_COUNT && winningNumber.hasMatchingBonusNumberWith(userLotto);

        return Rank.findRankByMatchCount(matchCount, matchedBonusNumber);
    }
}
