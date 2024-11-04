package lotto.utils;

import lotto.constants.errorType.WinningNumberErrorType;

import java.util.List;

public class WinningNumberValidation {

    public static void validateNumberRange(List<Integer> winningNumbers) {
        for(int winningNumber : winningNumbers) {
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

}
