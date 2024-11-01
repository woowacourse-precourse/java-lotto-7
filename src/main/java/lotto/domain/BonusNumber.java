package lotto.domain;

import lotto.validator.BonusNumberValidator;

public class BonusNumber {

    private final int bonusNumber;
    private final BonusNumberValidator validator;

    public BonusNumber(int bonusNumber, Lotto lotto, BonusNumberValidator validator) {
        this.validator = validator;
        validator.validate(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
