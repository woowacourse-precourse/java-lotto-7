package lotto.validation;

import lotto.domain.WinningNumbers;

public class BonusNumberValidator implements Validator<WinningNumbers> {
    private final int bonusNumber;
    private final String errorMessage;

    public BonusNumberValidator(int bonusNumber, String errorMessage) {
        this.bonusNumber = bonusNumber;
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(WinningNumbers winningNumbers) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
