package lotto.model;

public class WinningInfo {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningInfo(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers == null || bonusNumber == null) {
            throw new IllegalStateException("당첨 정보가 초기화되지 않았습니다.");
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
