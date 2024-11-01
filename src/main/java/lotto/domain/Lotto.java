package lotto.domain;

import static lotto.constant.ExceptionMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage(6));
        }
        Set<Integer> filteredNumbers = new HashSet<>();
        filteredNumbers.addAll(numbers);
        if (filteredNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }

        boolean overRange = numbers.stream()
            .anyMatch(number -> number > 45 || number < 1);
        if (overRange) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage(1, 45));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
