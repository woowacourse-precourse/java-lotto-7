package lotto.validation;

import lotto.error.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class DrawValidation {
    public static final int CORRECT_WINNING_NUMBERS_COUNT = 6;
    public static final int WHOLE_NUMBERS_COUNT = 7;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

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

    public static void validateWinningNumberRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number > END_NUMBER || number < START_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber > END_NUMBER || bonusNumber < START_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateDuplicatedWinningNumbers(List<Integer> winningNumbers) {
        HashSet<Integer> hashSet = new HashSet<>(winningNumbers);
        if (hashSet.size() != CORRECT_WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

}
