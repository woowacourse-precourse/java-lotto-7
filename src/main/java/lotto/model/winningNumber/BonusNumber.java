package lotto.model.winningNumber;

import static lotto.model.lotto.LotteryRule.MAX_LOTTERY_NUMBER;
import static lotto.common.Exceptions.OUT_OF_LOTTERY_NUMBER_RANGE;

import lotto.model.lotto.LotteryRule;

public record BonusNumber(int number) {

    public BonusNumber {
        validate(number);
    }

    private void validate(int number) {
        if (number < LotteryRule.MIN_LOTTERY_NUMBER
                || number > MAX_LOTTERY_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
        }
    }
}
