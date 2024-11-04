package lotto.domain.winning;

import lotto.validator.WinningValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = validateAndConvertBonusNumber(bonusNumber);
    }

    private int validateAndConvertBonusNumber(String bonusNumber) {
        WinningValidator.validateNullOrEmpty(bonusNumber);
        WinningValidator.validateBonusNumberIsNumeric(bonusNumber);
        int number = Integer.parseInt(bonusNumber);
        WinningValidator.validateNumberInRange(number);

        return number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
