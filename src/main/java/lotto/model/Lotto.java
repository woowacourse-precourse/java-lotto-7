package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.global.enums.PrintMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.global.enums.PrintMessage.NOT_ALLOWED_DUPLICATE_LOTTO_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(NOT_ALLOWED_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
