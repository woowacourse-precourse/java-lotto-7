package lotto.domain;

import lotto.exception.winningLotto.BonusNumberDuplicatedException;

final public class WinningLotto {

    private final Lotto winningNumbers;
    private final Number bonusNumber;

    public WinningLotto(Lotto winningNumbers, Number bonusNumber) {
        validateBonusNumberNotDuplicated(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumberNotDuplicated(Lotto winningNumbers, Number bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicatedException();
        }
    }
}
