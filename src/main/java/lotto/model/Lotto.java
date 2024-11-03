package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

public record Lotto(List<Integer> numbers) {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBERS_SIZE);
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new LottoException(ErrorMessages.LOTTO_NUMBERS_DUPLICATE);
        }
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
