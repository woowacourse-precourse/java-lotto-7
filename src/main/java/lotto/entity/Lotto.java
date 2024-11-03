package lotto.entity;

import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;
import static lotto.constant.Policy.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_INVALID_SIZE);
        }
    }

    private void validateInRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(this::isInRangeNumber);

        if (!isValid) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
        }
    }

    private boolean isInRangeNumber(Integer number) {
        return number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_DUPLICATED);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
