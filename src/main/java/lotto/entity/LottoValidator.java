package lotto.entity;

import static lotto.config.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.config.LottoConfig.LOTTO_MIN_NUMBER;
import static lotto.config.LottoConfig.LOTTO_NUMBER_COUNT;
import static lotto.exception.ExceptionUtils.throwIllegalArgument;
import static lotto.exception.LottoExceptionMessage.DUPLICATE_NUMBERS;
import static lotto.exception.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.LottoExceptionMessage.NULL_OR_EMPTY_NUMBERS;
import static lotto.exception.LottoExceptionMessage.NUMBER_OUT_OF_RANGE;

import java.util.List;
import java.util.Objects;

public class LottoValidator {

    public static void validate(List<Integer> numbers) {
        validateNullOrEmpty(numbers);
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private static void validateNullOrEmpty(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.stream().anyMatch(Objects::isNull)) {
            throwIllegalArgument(NULL_OR_EMPTY_NUMBERS);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throwIllegalArgument(INVALID_NUMBER_COUNT);
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT.getValue()) {
            throwIllegalArgument(DUPLICATE_NUMBERS);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(
                number -> !(LOTTO_MIN_NUMBER.getValue() <= number && number <= LOTTO_MAX_NUMBER.getValue()))) {
            throwIllegalArgument(NUMBER_OUT_OF_RANGE);
        }
    }
}
