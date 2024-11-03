package lotto.domain;

import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(LottoException.LOTTO_LENGTH_NOT_VALID.getMessage());
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size())
            throw new IllegalArgumentException(LottoException.WINNING_NUMBERS_DUPLICATED.getMessage());
    }
}
