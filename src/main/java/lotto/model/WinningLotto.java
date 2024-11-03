package lotto.model;

import lotto.validator.BonusNumberValidator;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.lotto = winningLotto;
        BonusNumberValidator.validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
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
