package lotto.model.winningNumber;

import static lotto.model.lotto.LotteryRule.MAX_LOTTERY_NUMBER;
import static lotto.common.Exceptions.OUT_OF_LOTTERY_NUMBER_RANGE;

import lotto.model.lotto.LotteryRule;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LotteryRule.MIN_LOTTERY_NUMBER
                || number > MAX_LOTTERY_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
