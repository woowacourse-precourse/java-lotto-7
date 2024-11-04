package lotto.domain;

import lotto.validation.BonusNumberValidator;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningNumbers = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        BonusNumberValidator.validateBonusNumber(winningLotto.getNumbers(), bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
