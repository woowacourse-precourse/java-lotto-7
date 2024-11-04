package lotto.model;

import java.util.List;

public class LottoDrawMachine {
    private final WinningNumbers winningNumbers;

    public LottoDrawMachine(List<Integer> drawNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(drawNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return winningNumbers.getBonusNumber();
    }

}
