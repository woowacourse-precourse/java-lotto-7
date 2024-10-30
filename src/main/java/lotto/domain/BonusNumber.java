package lotto.domain;

import lotto.exception.ExceptionMessages;

public class BonusNumber {

    private static final int LOTTERY_MIN = 1;
    private static final int LOTTERY_MAX = 45;

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateOutOfRangeNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateOutOfRangeNumber(int bonusNumber) {
        if (bonusNumber > LOTTERY_MAX || bonusNumber < LOTTERY_MIN) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
