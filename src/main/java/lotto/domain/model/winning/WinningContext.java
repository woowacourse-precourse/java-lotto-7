package lotto.domain.model.winning;

import lotto.domain.model.bonus.BonusNumber;

public class WinningContext {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningContext(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
