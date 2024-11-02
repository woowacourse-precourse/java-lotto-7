package lotto;

import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers() {
        winningNumbers = RandomMaker.getRandomNumbers(NUMBER_COUNT + 1);
        bonusNumber = winningNumbers.getLast();
        winningNumbers.removeLast();
    }

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}