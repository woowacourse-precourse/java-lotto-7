package lotto.model;

import static lotto.Exception.ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRank(Lotto userLotto) {
        return Ranking.calculateRanking(winningNumber.calculateMatchInfo(userLotto, bonusNumber));
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoConstant.MIN_LOTTO_NUMBER.getValue() || bonusNumber > LottoConstant.MAX_VALID_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_RANGE_LOTTO_NUMBER.getMessage());
        }

        winningNumber.checkBonusNumberDuple(bonusNumber);
    }
}
