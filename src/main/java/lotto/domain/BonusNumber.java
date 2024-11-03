package lotto.domain;

import lotto.constant.ErrorMessage;

import static lotto.constant.NumberConstant.*;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateInRange(bonusNumber);
    }

    private void validateInRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_RANGE_START || LOTTO_NUMBER_RANGE_END < bonusNumber) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_RANGE.getMessage());
        }

        if (bonusNumber <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_POSITIVE_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
