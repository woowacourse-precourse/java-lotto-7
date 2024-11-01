package lotto.validator;

import static lotto.configuration.LottoConfiguration.LOTTO_MAX_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_MIN_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_NUMBER_COUNT;
import static lotto.exception.LottoExceptionMessage.DUPLICATE_NUMBERS;
import static lotto.exception.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.LottoExceptionMessage.NULL_OR_EMPTY_NUMBERS;
import static lotto.exception.LottoExceptionMessage.NUMBER_OUT_OF_RANGE;

import java.util.List;
import java.util.Objects;
import lotto.exception.LottoValidationException;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.stream().anyMatch(Objects::isNull)) {
            throw new LottoValidationException(NULL_OR_EMPTY_NUMBERS);
        }
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new LottoValidationException(INVALID_NUMBER_COUNT);
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new LottoValidationException(DUPLICATE_NUMBERS);
        }
        if (numbers.stream().anyMatch(
                number -> !(LOTTO_MIN_NUMBER.getValue() <= number && number <= LOTTO_MAX_NUMBER.getValue()))) {
            throw new LottoValidationException(NUMBER_OUT_OF_RANGE);
        }
    }
}
