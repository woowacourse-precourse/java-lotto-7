package lotto.domain;

import lotto.validator.BonusNumberValidator;

public class BonusNumber {
    private final int value;

    public BonusNumber(String value, Lotto winningNumbers) {
        validate(value, winningNumbers);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value, Lotto winningNumbers) {
        BonusNumberValidator.isNumeric(value);
        BonusNumberValidator.validateNumberRange(value);
        BonusNumberValidator.checkBonusNumberDuplicate(value, winningNumbers);
    }

    public int getValue() {
        return value;
    }
}
