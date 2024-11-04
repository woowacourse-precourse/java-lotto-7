package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int RANDOM_COUNT = 6;
    private final List<WinningNumber> winningNumbers;
    private final BonusNumber bonusNumber;


    public WinningNumbers(List<WinningNumber> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = null;
    }

    public WinningNumbers(List<WinningNumber> winningNumbers, BonusNumber bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
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

    private void validateBonusNumber(List<WinningNumber> winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.stream().anyMatch(num -> num.winningNumber() == bonusNumber.bonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
