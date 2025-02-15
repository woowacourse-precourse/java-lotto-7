package lotto.domain;

import lotto.constant.LotteryConst;
import lotto.exception.ExceptionMessages;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateOutOfRangeNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean compareNumber(int number) {
        return bonusNumber == number;
    }

    private void validateOutOfRangeNumber(int bonusNumber) {
        if (bonusNumber > LotteryConst.MAX.getValue() || bonusNumber < LotteryConst.MIN.getValue()) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
