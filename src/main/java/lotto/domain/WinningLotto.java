package lotto.domain;

public class WinningLotto {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumbers) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumbers;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
