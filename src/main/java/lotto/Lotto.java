package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.WRONG_LENGTH);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(Constants.DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
