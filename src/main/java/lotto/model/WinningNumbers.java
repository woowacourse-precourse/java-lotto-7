package lotto.model;

import lotto.view.constant.ErrorConstant;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    public boolean checkBonusMatch(Lotto lotto) {
        return lotto.isInclude(bonusNumber.getBonusNumber());
    }

    private void validate(BonusNumber bonusNumber) {
        if (winningNumbers.isInclude(bonusNumber.getBonusNumber()))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_UNIQUE_NUMBER);
    }
}
