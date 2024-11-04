package lotto.model;

import lotto.validator.BonusNumberValidator;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.lotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        bonusNumberValidator.validateBonusNumber(lotto, bonusNumber);
    }

    public static WinningLotto of(Lotto winningLotto, int bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
