package lotto.model;

import lotto.enums.ExceptionMessage;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
