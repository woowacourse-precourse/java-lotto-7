package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private static final int WINNING_NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ERROR_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String ERROR_NO_DUPLICATE = "[ERROR] 당첨 번호는 중복되면 안됩니다.";
    private static final String ERROR_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_RANGE = "[ERROR] 보너스 번호는 1~45 범위 안의 숫자여야 합니다.";
    private static final String ERROR_BONUS_DUPLICATE = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";


    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateCount(winningNumbers);
        validateNoDuplicate(winningNumbers);
        validateAllNumbersInRange(winningNumbers);
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberNotInWinningNumbers(winningNumbers,bonusNumber);
    }

    private void validateCount(List<Integer> winningNumbers) {
        if (!isCorrectCount(winningNumbers)) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_COUNT);
        }
    }

    private boolean isCorrectCount(List<Integer> winningNumbers) {
        return winningNumbers.size() == WINNING_NUMBERS_COUNT;
    }

    private void validateNoDuplicate(List<Integer> winningNumbers) {
        if (hasDuplicates(winningNumbers)) {
            throw new IllegalArgumentException(ERROR_NO_DUPLICATE);
        }
    }

    private boolean hasDuplicates(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() != winningNumbers.size();
    }

    private void validateAllNumbersInRange(List<Integer> winningNumbers) {
        if (hasOutOfRangeNumber(winningNumbers)) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    private boolean hasOutOfRangeNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_RANGE);
        }
    }

    private boolean isOutOfRange(int bonusNumber) {
        return bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER;
    }

    private void validateBonusNumberNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (isDuplicateWithWinningNumbers(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }

    private boolean isDuplicateWithWinningNumbers(List<Integer> winningNumbers,int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        Set<Integer> matchedNumbers = new HashSet<>(winningNumbers);
        matchedNumbers.retainAll(lotto.getNumbers());
        return matchedNumbers.size();
    }

    public boolean isBonusMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
