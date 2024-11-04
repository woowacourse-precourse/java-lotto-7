package lotto.model;

import static lotto.constants.NumberConstants.LOTTO_COUNT_6;
import static lotto.constants.NumberConstants.LOTTO_RANGE_END;
import static lotto.constants.NumberConstants.LOTTO_RANGE_START;
import static lotto.message.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.message.ErrorMessage.LOTTO_SIZE_6;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_EXCEPTION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateNumberRage(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT_6) {
            throw new IllegalArgumentException(LOTTO_SIZE_6.getMessage());
        }
    }

    private void validateNumberRage(List<Integer> numbers) {
        for (final int number : numbers) {
            if (number < LOTTO_RANGE_START || number > LOTTO_RANGE_END) {
                throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
            }
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (final int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
            }
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
