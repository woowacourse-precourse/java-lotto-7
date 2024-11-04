package lotto.utils;

import lotto.constants.errorType.WinningNumberErrorType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidation {

    public static void validateNumberRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException(WinningNumberErrorType.INVALID_WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    public static int validateNumberFormat(String rawWinningNumber) {
        try {
            return Integer.parseInt(rawWinningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WinningNumberErrorType.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != new HashSet<>(winningNumbers).size()) {
            throw new IllegalArgumentException(WinningNumberErrorType.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }
}
