package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_SIZE = "로또 번호는 6개여야 합니다.";
    private static final String ERROR_DUPLICATE = "로또 번호에 중복된 숫자가 있습니다.";
    private static final String ERROR_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int NUMBERS_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}