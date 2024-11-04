package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int RANDOM_COUNT = 6;
    private final List<WinningNumber> winningNumbers;

    public WinningNumbers(List<WinningNumber> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<WinningNumber> winningNumbers) {
        if (winningNumbers.size() != RANDOM_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정확히 6개의 숫자여야 합니다.");
        }
        validateDuplicateWinningNumbers(winningNumbers);
    }

    private void validateDuplicateWinningNumbers(List<WinningNumber> winningNumbers) {
        Set<Integer> uniqueNumbers = winningNumbers.stream()
                .map(WinningNumber::winningNumber)
                .collect(Collectors.toSet());

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }

    public List<WinningNumber> getNumbers() {
        return winningNumbers;
    }
}
