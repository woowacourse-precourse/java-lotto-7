package lotto.model;

import java.util.List;

public class Lotto {
    private final String LENGTH_MISMATCH = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final String UNIQUENESS = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private final String OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final int MAX_VALUE = 45;
    private final int MIN_VALUE = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateUniqueness(numbers);
        validateOutOfRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LENGTH_MISMATCH);
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(UNIQUENESS);
        }
    }
    private void validateOutOfRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(value -> value >= MIN_VALUE && value <= MAX_VALUE)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
