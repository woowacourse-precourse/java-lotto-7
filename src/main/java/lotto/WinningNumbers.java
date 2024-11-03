package lotto;

public class WinningNumbers {
    private final WinningLottoNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningLottoNumbers winningNumbers, BonusNumber bonusNumber) {
        validateBonusNumberDuplicate();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberDuplicate() {
    }
}
