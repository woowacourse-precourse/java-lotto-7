package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class NumberValidation {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    private NumberValidation() {
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> verifyNumbers = new HashSet<>(numbers);
        if (numbers.size() != verifyNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERROR.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBER_CONTAINS_BONUS_NUMBER.getMessage());
        }
    }

}
