package lotto.model;

import static lotto.utils.ErrorMessage.INVALID_LOTTO_NUMBER;
import static lotto.utils.ErrorMessage.INVALID_RANGE;
import static lotto.utils.ErrorMessage.LOTTO_NUMBER_DUPLICATION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkSame(numbers);
        checkRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }

    private void checkSame(List<Integer> numbers) {
        Set<Integer> numberSize = new HashSet<>(numbers);
        if (numbers.size() != numberSize.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION);
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException(INVALID_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
