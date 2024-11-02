package lotto.committee;

import java.util.TreeSet;

public class WinningNumbers {

    private final TreeSet<Integer> mainNumbers;
    private final Integer bonusNumber;

    private WinningNumbers(TreeSet<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    public TreeSet<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
