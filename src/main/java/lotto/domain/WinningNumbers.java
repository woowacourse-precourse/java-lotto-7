package lotto.domain;

import lotto.constants.ErrorMessage;

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
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage()
            );
        }
    }

    public WinningLottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
