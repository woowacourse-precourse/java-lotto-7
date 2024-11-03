package lotto.model;

import lotto.util.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicate(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_SIZE_ERROR.getMessage());
        }
    }

    private static void validateNoDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.WINNING_NUMBERS_DUPLICATE_ERROR.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_RANGE || number > MAX_LOTTO_RANGE)) {
            throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_ERROR.getMessage()
            );
        }
    }

}
