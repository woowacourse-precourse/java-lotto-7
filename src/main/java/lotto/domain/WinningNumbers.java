package lotto.domain;

public class WinningNumbers {
    private final WinningLottoNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningLottoNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusNumberDuplicate();
    }

    public static WinningNumbers from(String winningNumbersInput, String bonusNumberInput) {
        WinningLottoNumbers winningNumbers = WinningLottoNumbers.from(winningNumbersInput);
        BonusNumber bonusNumber = BonusNumber.from(bonusNumberInput);
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private void validateBonusNumberDuplicate() {
        if (winningNumbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public WinningLottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
