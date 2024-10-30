package lotto.model;

import java.util.List;

public class WinningNumbers {

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
