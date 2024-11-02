package lotto.model;

public class ThirdRankStrategy implements LottoWinningStrategy {
    private static final Integer NUMBER_OF_MATCH = 5;
    private static final boolean BONUS_NUMBER_MATCH_STATUS = false;

    @Override
    public boolean isWinning(WinningLotto winningLotto, Lotto myLotto, BonusNumber bonusNumber) {
        if (isNumberMatch(winningLotto, myLotto) && isBonusMatch(winningLotto, bonusNumber)) {
            return true;
        }
        return false;
    }

    private boolean isNumberMatch(WinningLotto winningLotto, Lotto myLotto) {
        return NUMBER_OF_MATCH.equals(getMatchCount(winningLotto, myLotto));
    }

    private boolean isBonusMatch(WinningLotto winningLotto, BonusNumber bonusNumber) {
        return BONUS_NUMBER_MATCH_STATUS == winningLotto.getWinNumbers()
                .contains(bonusNumber.getNumber());
    }

    @Override
    public int getConditionOfMatchCount() {
        return NUMBER_OF_MATCH;
    }

    @Override
    public boolean isBonusNumberRequired() {
        return BONUS_NUMBER_MATCH_STATUS;
    }

}
