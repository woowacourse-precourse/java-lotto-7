package lotto.utils;

import lotto.constants.errorType.WinningNumberErrorType;

import java.util.List;

public class WinningNumberValidation {

    public static void validateNumberCount(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException(WinningNumberErrorType.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    public static void validateNumberRange(int winningNumber) {
        if(winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException(WinningNumberErrorType.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    public static int validateNumberFormat(String rawWinningNumber) {
        try {
            return Integer.parseInt(rawWinningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WinningNumberErrorType.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

}
