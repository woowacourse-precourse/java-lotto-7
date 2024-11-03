package lotto.model;

import static lotto.exception.ErrorMessage.DUPLICATE_BONUS_NUMBER;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        super(winningLottoNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        checkDuplicateNumber(bonusNumber);
    }

    private void checkDuplicateNumber(int bonusNumber) {
        if (super.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public Rank calculateRank(Lotto lotto) {
        int sameNumberCount = super.countSameNumber(lotto);
        boolean isBonusNumberWinning = checkBonusNumberWinning(lotto);
        return Rank.getRank(sameNumberCount, isBonusNumberWinning);
    }

    private boolean checkBonusNumberWinning(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
