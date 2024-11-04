package lotto.domain;

import lotto.validator.BonusNumberValidator;

public class BonusNumber {

    private static BonusNumber instance;
    private final int bonusNumber;
    private final BonusNumberValidator validator;

    private BonusNumber(int bonusNumber, Lotto lotto, BonusNumberValidator validator) {
        this.validator = validator;
        validator.validate(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber getInstance(int bonusNumber, Lotto lotto,
        BonusNumberValidator validator) {
        if (instance == null) {
            instance = new BonusNumber(bonusNumber, lotto, validator);
        }
        return instance;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
