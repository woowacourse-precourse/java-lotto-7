package lotto.model.lotto.validator;

import static lotto.exception.ErrorBase.LOTTO_NUMBERS_DUPLICATE;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_INVALID_SIZE;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;

import java.util.List;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        boolean outOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);

        if (outOfRange) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }
}
