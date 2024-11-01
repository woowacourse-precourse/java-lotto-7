package lotto.model;

public class FourthRankStrategy implements LottoWinningStrategy {
    private static final Integer NUMBER_OF_MATCH = 4;

    @Override
    public boolean isWinning(WinningLotto winningLotto, Lotto myLotto, BonusNumber bonusNumber) {
        if (NUMBER_OF_MATCH.equals(getMatchCount(winningLotto, myLotto))) {
            return true;
        }
        return false;
    }
}
