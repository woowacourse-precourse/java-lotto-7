package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> lotteryNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> lotteryNumbers, Integer bonusNumber) {
        this.lotteryNumbers = lotteryNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
