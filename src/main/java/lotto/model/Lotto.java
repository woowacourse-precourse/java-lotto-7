package lotto.model;

import message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = sortInAscendingOrder(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateHasDuplicateNumber(numbers);
    }

    private List<Integer> sortInAscendingOrder(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT.message());
        }
    }

    private void validateHasDuplicateNumber(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.message());
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
