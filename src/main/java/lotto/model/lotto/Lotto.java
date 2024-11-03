package lotto.model.lotto;

import static lotto.error.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.error.ErrorMessage.INVALID_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MAX_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        validateMaxLength(numbers);
        validateDuplicate(numbers);
        return new Lotto(numbers);
    }

    public boolean hasBonus(Integer number) {
        return numbers.contains(number);
    }

    public int countMatch(Lotto winning) {
        return (int) numbers.stream()
                .filter(winning.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static void validateMaxLength(final List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_COUNT.getMessage(), MAX_NUMBER_COUNT));
        }
    }

    private static void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }
}
