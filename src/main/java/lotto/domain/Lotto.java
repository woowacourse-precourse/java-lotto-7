package lotto.domain;

import static lotto.resources.Constants.LOTTO_TOTAL_NUMBERS;
import static lotto.resources.ErrorMessages.DUPLICATE_LOTTO_NUMBER;
import static lotto.resources.ErrorMessages.INVALID_LOTTO_TOTAL_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_TOTAL_NUMBERS) {
            throw new IllegalArgumentException(INVALID_LOTTO_TOTAL_NUMBER.getMessage());
        }
    }

    private void validateDuplicateNumbers(final List<Integer> numbers) {
        long sizeWithOutDuplicate = numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != sizeWithOutDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
