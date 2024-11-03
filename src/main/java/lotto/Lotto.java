package lotto;

import static lotto.NumberType.LOTTO_MAX_NUMBER;
import static lotto.NumberType.LOTTO_MIN_NUMBER;
import static lotto.NumberType.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
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

    public String getNumbers() {
        return numbers.toString();
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinctedNumbers = new HashSet<>(numbers);

        if (distinctedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_RANGE);
            }
        }
    }
}
