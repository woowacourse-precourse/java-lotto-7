package lotto.entity;

import static lotto.exception.ExceptionUtils.throwIllegalArgument;
import static lotto.exception.LottoExceptionMessage.DUPLICATE_NUMBERS;
import static lotto.exception.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.LottoExceptionMessage.NUMBER_OUT_OF_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throwIllegalArgument(INVALID_NUMBER_COUNT);
        }
        if (numbers.stream().distinct().count() != 6) {
            throwIllegalArgument(DUPLICATE_NUMBERS);
        }
        if (numbers.stream().anyMatch(number -> !(1 <= number && number <= 45))) {
            throwIllegalArgument(NUMBER_OUT_OF_RANGE);
        }
    }


}
