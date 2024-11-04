package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String ERROR_EMPTY_NUMBERS = "[ERROR] 로또 번호는 비어 있을 수 없습니다.";
    private static final String ERROR_INVALID_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NUMBERS);
        }

        if (numbers.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE);
        }

        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_SIZE);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
