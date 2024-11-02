package lotto.committee.drawstation;

import java.util.TreeSet;

public class WinningNumbers {

    final TreeSet<Integer> mainNumbers;
    final Integer bonusNumber;

    WinningNumbers(TreeSet<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public TreeSet<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
