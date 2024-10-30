package lotto.entity;

import static lotto.exception.ExceptionUtils.throwIllegalArgument;
import static lotto.exception.LottoExceptionMessage.DUPLICATE_NUMBERS;
import static lotto.exception.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.LottoExceptionMessage.NUMBER_OUT_OF_RANGE;

import java.util.List;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throwIllegalArgument(INVALID_NUMBER_COUNT);
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throwIllegalArgument(DUPLICATE_NUMBERS);
        }
        if (numbers.stream().anyMatch(number -> !(LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER))) {
            throwIllegalArgument(NUMBER_OUT_OF_RANGE);
        }
    }


}
