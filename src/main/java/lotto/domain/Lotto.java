package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.error.ErrorCode;

public class Lotto {

    protected static final int LOTTO_SIZE = 6;
    protected static final int LOTTO_MIN_NUMBER = 1;
    protected static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    protected static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private static void validateDuplicated(List<Integer> numbers) {
        boolean isDuplicated = numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE;
        if (isDuplicated) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean isOverRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
        if (isOverRange) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
