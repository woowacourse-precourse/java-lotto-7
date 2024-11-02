package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }
    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.stream().forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        });
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueWinningNumbers = new HashSet(winningNumbers);
        if (winningNumbers.size() != uniqueWinningNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }
    
    
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
