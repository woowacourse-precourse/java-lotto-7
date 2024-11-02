package lotto.model;

import lotto.exception.DuplicateLottoNumberException;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (isContainsBonusNumberInLotto(lotto, bonusNumber)) {
            throw new DuplicateLottoNumberException();
        }
    }

    private boolean isContainsBonusNumberInLotto(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
