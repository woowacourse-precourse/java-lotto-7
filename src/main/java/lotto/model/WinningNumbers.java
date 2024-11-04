package lotto.model;

import java.util.List;

// 사용자가 입력한 로또 당첨 번호와 보너스 번호.
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
