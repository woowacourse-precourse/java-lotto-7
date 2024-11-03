package lotto.model;

import lotto.constants.ExceptionMessage;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        if (hasDuplicateNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicateNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.containsBonusNumber(bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        return winningLotto.countMatchingNumbers(lotto);
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.containsBonusNumber(bonusNumber);
    }
}
