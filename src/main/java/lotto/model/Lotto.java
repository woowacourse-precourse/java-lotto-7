package lotto.model;

import static lotto.constants.CommonConstants.LOTTO_SIZE;
import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_ORDER;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_SIZE;
import static lotto.exception.ExceptionMessage.NULL_LOTTO;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNull(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
        validateAscendingOrder(numbers);
    }

    private void validateNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(NULL_LOTTO.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateAscendingOrder(List<Integer> numbers) {
        boolean isAscending = IntStream.range(0, numbers.size() - 1)
                .allMatch(i -> numbers.get(i) < numbers.get(i + 1));

        if (!isAscending) {
            throw new IllegalArgumentException(INVALID_LOTTO_ORDER.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public int getId() {
        return Objects.hashCode(numbers);
    }
}
