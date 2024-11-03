package lotto.model.winningNumber;

import static lotto.model.lotto.LotteryRule.MAX_LOTTERY_NUMBER;
import static lotto.exception.Exceptions.OUT_OF_LOTTERY_NUMBER_RANGE;

import lotto.model.lotto.LotteryRule;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < LotteryRule.MIN_LOTTERY_NUMBER || bonusNumber > MAX_LOTTERY_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
