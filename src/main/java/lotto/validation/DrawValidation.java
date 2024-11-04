package lotto.validation;

import lotto.error.ErrorMessage;

import java.util.List;

public class DrawValidation {
    public static final int CORRECT_WINNING_NUMBERS_COUNT = 6;

    public static void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != CORRECT_WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }
}
