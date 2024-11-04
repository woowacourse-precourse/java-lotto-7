package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidWinningNumbersDuplicateException;
import lotto.exception.InvalidWinningNumbersSizeException;

public class WinningNumbers {
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;
    private static final int WINNING_NUMBERS_SIZE = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = List.copyOf(winningNumbers); // 불변 리스트로 복사
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new InvalidWinningNumbersSizeException();
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new InvalidWinningNumbersDuplicateException();
        }

        if (!uniqueNumbers.add(bonusNumber)) {
            throw new InvalidWinningNumbersDuplicateException();
        }
    }

    public boolean isContain(int number) {
        return winningNumbers.contains(number);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
