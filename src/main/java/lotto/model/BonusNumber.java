package lotto.model;

import static lotto.utils.Constants.MAX_LOTTO_NUMBER;
import static lotto.utils.Constants.MIN_LOTTO_NUMBER;

import lotto.utils.ErrorMessages;


public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        checkBonusNumberRange(bonusNumber);
    }

    private void checkBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_BOUNDS_LOTTO_NUMBER);
        }
    }
}
