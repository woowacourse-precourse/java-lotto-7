package lotto.validation;

import lotto.error.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class DrawValidation {
    public static final int CORRECT_WINNING_NUMBERS_COUNT = 6;
    public static final int WHOLE_NUMBERS_COUNT = 7;

    public static void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != CORRECT_WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    public static void validateDuplicatedNumber(List<Integer> winningNumbers, int bonusNumber) {
        HashSet<Integer> hashSet = new HashSet<>(winningNumbers);
        hashSet.add(bonusNumber);
        if (hashSet.size() != WHOLE_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }
}
