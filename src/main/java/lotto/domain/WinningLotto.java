package lotto.domain;

import lotto.validation.WinningNumberValidator;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        WinningNumberValidator.validateBonusNumber(winningLotto.getNumbers(), bonusNumber);
        this.winningNumbers = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
