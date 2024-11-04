package lotto.model;

public class WinningNumber {
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public void setWinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        checkExistWinningNumbers();
        this.bonusNumber = bonusNumber;
    }

    private void checkExistWinningNumbers() {
        if (winningNumbers == null) {
            throw new IllegalStateException("당첨 번호 먼저 설정해 주세요.");  //TODO
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
