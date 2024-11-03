package lotto;

import lotto.enums.CustomError;

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
            throw new IllegalArgumentException(CustomError.INVALID_LOTTO_LIST_SIZE.getErrorMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(CustomError.INVALID_LOTTO_DUPLICATION.getErrorMessage());
        }

        for (Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(CustomError.INVALID_LOTTO_NUM_RANGE.getErrorMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
