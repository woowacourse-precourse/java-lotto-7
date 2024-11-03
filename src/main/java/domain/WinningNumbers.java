package domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {

        Validate validate = new Validate();

        validate.validateIsCountSix(winningNumbers);
        validate.validateIsInRange(winningNumbers);
        validate.validateIsDuplicate(winningNumbers);

        Collections.sort(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
    @Override
    public String toString() {
        return winningNumbers.toString();
    }
}
