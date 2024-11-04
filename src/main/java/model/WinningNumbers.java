package model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) matchCount++;
        }
        return matchCount;
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}