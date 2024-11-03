package lotto.model;

import lotto.validator.LottoValidator;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        LottoValidator.validateSize(winningNumbers);
        LottoValidator.validateNoDuplicates(winningNumbers);
        LottoValidator.validateRange(winningNumbers);
        LottoValidator.validateSingleNumberRange(bonusNumber);
        LottoValidator.validateBonusNotInWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
