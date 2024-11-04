package lotto.validator;

import lotto.enums.ErrorMessage;

import java.util.List;

public class WinningNumbersValidator {
    private static final int NUMBER_SIZE_CONDITION = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateWinningNumbers(List<Integer> numbers) {
        validateWinningNumberSize(numbers);
        validateNumberRange(numbers);
        validateNumberDuplicate(numbers);
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(numbers, bonusNumber);
    }

    private static void validateWinningNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE_CONDITION) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private static void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBER_SIZE_CONDITION) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateBonusRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateBonusDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }


}
