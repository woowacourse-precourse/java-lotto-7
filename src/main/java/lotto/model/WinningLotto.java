package lotto.model;

import lotto.constants.ErrorMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        if (hasDuplicateNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicateNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.containsBonusNumber(bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        return this.lotto.countMatchingNumbers(lotto);
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.containsBonusNumber(bonusNumber);
    }
}
