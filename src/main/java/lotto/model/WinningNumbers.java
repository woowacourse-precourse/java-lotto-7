package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String BONUS_DUPLICATE_ERROR_MESSAGE = "[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야 합니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 당첨 번호와 보너스 번호는 1에서 45 사이의 숫자여야 합니다.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateSize(winningNumbers);
        validateNumberRange(winningNumbers, bonusNumber);
        validateNoDuplicateNumbers(winningNumbers);
        validateNoBonusDuplicate(winningNumbers, bonusNumber);
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> winningNumbers, int bonusNumber) {
        for (int number : winningNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateNoBonusDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
