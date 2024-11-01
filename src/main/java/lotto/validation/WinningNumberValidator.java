package lotto.validation;

import lotto.constants.ErrorMessageConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {
    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumberCount(winningNumbers);
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberDuplicate(winningNumbers);
    }

    private static void validateWinningNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private static void validateWinningNumberRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_WINNING_NUMBER_RANGE);
        }
    }

    private static void validateWinningNumberDuplicate(List<Integer> winningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        if (uniqueWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_WINNING_NUMBER_DUPLICATE);
        }
    }
}
