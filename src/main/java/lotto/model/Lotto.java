package lotto.model;

import lotto.enumMessage.ErrorMessage;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }

        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getMessage());
        }
    }

    public boolean isDuplicateWithLotto(int bonusNumber) {
        return numbers.stream()
                .anyMatch(num -> num.equals(bonusNumber));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
