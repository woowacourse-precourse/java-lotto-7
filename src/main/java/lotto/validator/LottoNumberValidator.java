package lotto.validator;

import static lotto.constants.ErrorMessages.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_COUNT);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_DUPLICATE);
        }
    }

    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }
}
