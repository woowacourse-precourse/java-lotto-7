package lotto.model;

import lotto.error.ErrorMessage;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.bonusNumber = -1;
    }

    private WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers createWithBonusNumber(WinningNumbers existingInstance, int bonusNumber) {
        validateBonusNumber(existingInstance.winningLotto, bonusNumber);
        return new WinningNumbers(existingInstance.winningLotto, bonusNumber);
    }

    public int getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningLotto);
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        if (bonusNumber == -1) {
            throw new IllegalStateException("[ERROR] 보너스 번호가 설정되지 않았습니다.");
        }
        return lotto.isContained(bonusNumber);
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateNoDuplicateBonusNumber(winningLotto, bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateNoDuplicateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContained(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
