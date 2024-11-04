package lotto.domain;

import lotto.exception.Lotto.NotDuplicatedNumberException;
import lotto.exception.Lotto.NotSixNumbersException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new NotSixNumbersException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>();
        for (int number : numbers) {
            checkNumbers.add(number);
        }

        if (numbers.size() != checkNumbers.size()) {
            throw new NotDuplicatedNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
