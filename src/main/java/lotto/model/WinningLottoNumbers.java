package lotto.model;

import lotto.validator.BonusNumberValidator;

public class WinningLottoNumbers {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLottoNumbers(Lotto winningLotto, int bonusNumber) {
        this.lotto = winningLotto;
        BonusNumberValidator.validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
