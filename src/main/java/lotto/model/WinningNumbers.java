package lotto.model;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class WinningNumbers {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateSizeOfWinningNumbers(winningNumbers);
        validateDuplicateOfWinningNumbers(winningNumbers);
        validateRangeOfLottoWinningNumbers(winningNumbers);
    }

    private void validateSizeOfWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicateOfWinningNumbers(List<Integer> winningNumbers) {
        List<Integer> validateDuplicate = winningNumbers.stream().distinct().toList();
        if (validateDuplicate.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private void validateRangeOfLottoWinningNumbers(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }
}
