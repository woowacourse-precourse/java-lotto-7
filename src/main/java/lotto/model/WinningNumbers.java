package lotto.model;

import java.util.List;

public class WinningNumbers {

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        winningNumbers = new Lotto(numbers);
        winningNumbers.checkBonusNumberDuplication(bonusNumber);
        bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
