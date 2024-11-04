package lotto.domain;

import static lotto.util.LottoNumberValidator.validateLottoNumbers;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateLottoNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public int getCurrentNumberCount(Lotto lotto) {
        int currentNumberCount = 0;

        for (int number : lotto.getNumbers()) {
            if (this.winningNumbers.contains(number)) {
                currentNumberCount++;
            }
        }
        return currentNumberCount;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
