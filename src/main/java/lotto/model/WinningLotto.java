package lotto.model;

import lotto.util.Validator;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank compareLotto(Lotto lotto) {
        int correctCount = winningNumbers.countCorrectNumbers(lotto);
        boolean containsBonusNumber = lotto.contains(bonusNumber.bonusNumber());

        return Rank.valueOf(correctCount, containsBonusNumber);
    }

    private void validate(Lotto winningNumbers, BonusNumber bonusNumber) {
        Validator.validateIsDuplicate(winningNumbers, bonusNumber.bonusNumber());
    }
}
