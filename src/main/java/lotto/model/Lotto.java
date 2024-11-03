package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Lotto(List<Integer> numbers) {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBERS_SIZE);
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBERS_DUPLICATE);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBERS_RANGE);
        }
    }

    public boolean containsNumber(Integer number) {
        return this.numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto mainNumbers) {
        Set<Integer> intersection = new HashSet<>(this.numbers);
        intersection.retainAll(mainNumbers.numbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
