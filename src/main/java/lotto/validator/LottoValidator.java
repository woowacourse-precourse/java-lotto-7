package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.ErrorMessage;

public class LottoValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_COUNT = 6;

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage(MIN_NUMBER, MAX_NUMBER));
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage(NUMBERS_COUNT));
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage(MIN_NUMBER, MAX_NUMBER));
        }
    }
}
