package lotto.model;

import static lotto.ExceptionMessage.LOTTO_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.ExceptionMessage.LOTTO_NUMBER_LENGTH_EXCEPTION;
import static lotto.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNoDuplicateNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_EXCEPTION.message());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION.message());
            }
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_EXCEPTION.message());
            }
        }
    }

}
