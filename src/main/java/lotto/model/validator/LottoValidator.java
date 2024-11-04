package lotto.model.validator;

import lotto.exception.Exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator extends NumberRangeValidator {
    public static void validateLotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberRange(numbers);
        validateNumberDuplication(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    Exception.INVALID_LOTTO_NUMBERS_SIZE.getMessage()
            );
        }
    }

    private static void validateNumberDuplication(List<Integer> numbers) {
        Set<Integer> duplicationCheck = new HashSet<>(numbers);

        if (duplicationCheck.size() != numbers.size()) {
            throw new IllegalArgumentException(Exception.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

}
