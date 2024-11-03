package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateDuplicates(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateDuplicates(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 수는 입력하실 수 없습니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
