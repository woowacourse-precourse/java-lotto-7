package lotto.domain;

import java.util.List;

import static lotto.exception.ExceptionCode.*;

public class Lotto {
    private final List<Integer> numbers;
    public static final int NUMBER_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNTS.message());
        }

        if (numbers.size() != numbers.stream().distinct().toList().size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
        }
    }

    public Long countMatches(List<Integer> numbers) {
        if (this.numbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_SIZE_NOT_MATCHED.message());
        }
        return this.numbers.stream().filter(numbers::contains).count();
    }
}
