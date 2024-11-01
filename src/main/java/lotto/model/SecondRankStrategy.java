package lotto.model;

public class SecondRankStrategy implements LottoWinningStrategy {
    private static final Integer NUMBER_OF_MATCH = 5;

    @Override
    public boolean isWinning(WinningLotto winningLotto, Lotto myLotto, BonusNumber bonusNumber) {
        if (NUMBER_OF_MATCH.equals(getMatchCount(winningLotto, myLotto)) && winningLotto.getWinNumbers()
                .contains(bonusNumber.getNumber())) {
            return true;
        }
        return false;
    }
}
