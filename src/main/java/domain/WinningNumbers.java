package domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        Collections.sort(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
