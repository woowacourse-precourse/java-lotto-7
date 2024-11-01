package lotto.model;

import lotto.exception.InvalidBonusNumberException;

import static lotto.exception.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.model.Lotto.MAX_LOTTO_NUMBER;
import static lotto.model.Lotto.MIN_LOTTO_NUMBER;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validate(bonusNumber);
    }

    public int get() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new InvalidBonusNumberException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
