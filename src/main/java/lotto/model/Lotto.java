package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoCountException;
import lotto.exception.LottoDuplicationException;
import lotto.exception.LottoRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        countValidation(numbers);
        duplicationValidation(numbers);
        rangeValidation(numbers);
    }

    private void countValidation(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoCountException();
        }
    }

    private void duplicationValidation(List<Integer> numbers) {
        Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
        if (duplicatedNumbers.size() != 6) {
            throw new LottoDuplicationException();
        }
    }

    private void rangeValidation(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0 || number > 45) {
                throw new LottoRangeException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
