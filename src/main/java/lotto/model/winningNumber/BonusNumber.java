package lotto.model.winningNumber;

import static lotto.model.lotto.LotteryRule.MAX_LOTTERY_NUMBER;

import lotto.model.lotto.LotteryRule;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < LotteryRule.MIN_LOTTERY_NUMBER || bonusNumber > MAX_LOTTERY_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
