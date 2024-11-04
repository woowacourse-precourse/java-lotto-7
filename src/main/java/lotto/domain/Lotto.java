package lotto.domain;

import static lotto.ErrorMessage.LOTTO_DUPLICATE_ERROR;
import static lotto.ErrorMessage.LOTTO_LENGTH_ERROR;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int LOTTO_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(LOTTO_LENGTH_ERROR.getMessage(), LOTTO_LENGTH));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long nonDuplicateNumberCount = numbers.stream().distinct().count();
        if (nonDuplicateNumberCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR.getMessage());
        }
    }
}
