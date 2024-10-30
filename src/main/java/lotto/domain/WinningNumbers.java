package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        this.winningNumbers = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        winningNumbers.checkBonusNumberDuplication(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() { return bonusNumber; }
}
