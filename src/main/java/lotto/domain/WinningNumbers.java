package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int RANDOM_COUNT = 6;
    private final List<WinningNumber> winningNumbers;

    public WinningNumbers(List<WinningNumber> winningNumbers) {
        validateDuplicateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateDuplicateNumbers(List<WinningNumber> winningNumbers) {
        Set<Integer> uniqueNumbers = winningNumbers.stream()
                .map(WinningNumber::winningNumber)
                .collect(Collectors.toSet());

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }
}
