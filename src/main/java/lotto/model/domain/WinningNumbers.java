package lotto.model.domain;

import java.util.List;
import lotto.config.LottoConfig;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return winningNumbers;
    }

    public int countMatch(List<Integer> numbers) {
        int count = LottoConfig.ZERO;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }
}
