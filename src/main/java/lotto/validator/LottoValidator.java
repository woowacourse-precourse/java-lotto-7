package lotto.validator;

import lotto.exception.LottoException;
import lotto.message.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateLottoNumbers(List<Integer> numbers) throws LottoException {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_COUNT_INVALID.getMessage());
        }
    }

    private static void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }
}
