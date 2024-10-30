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

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.stream().anyMatch(Objects::isNull)) {
            throwIllegalArgument(NULL_OR_EMPTY_NUMBERS);
        }
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throwIllegalArgument(INVALID_NUMBER_COUNT);
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT.getValue()) {
            throwIllegalArgument(DUPLICATE_NUMBERS);
        }
        if (numbers.stream().anyMatch(
                number -> !(LOTTO_MIN_NUMBER.getValue() <= number && number <= LOTTO_MAX_NUMBER.getValue()))) {
            throwIllegalArgument(NUMBER_OUT_OF_RANGE);
        }
    }

}
