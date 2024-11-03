package lotto.Validator;

import static lotto.constants.LottoConstants.*;
import static lotto.error.ErrorCode.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.error.ErrorCode.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.error.ErrorCode.LOTTO_NUMBER_DUPLICATE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    public static void validateLottoNumber(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
            }
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

}
