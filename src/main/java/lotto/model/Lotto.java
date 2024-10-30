package lotto.model;

import static lotto.model.LottoConfig.NUMBERS_SIZE;
import static lotto.model.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.model.LottoConfig.NUMBER_RANGE_MINIMUM;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (hasTooManyNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_TOO_MANY_NUMBERS.getMessage());
        }
        if (hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private boolean hasTooManyNumbers(List<Integer> numbers) {
        return numbers.size() != NUMBERS_SIZE;
    }

    private boolean hasDuplicatedNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < NUMBER_RANGE_MINIMUM || number > NUMBER_RANGE_MAXIMUM;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
