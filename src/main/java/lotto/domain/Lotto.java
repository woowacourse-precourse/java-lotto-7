package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ExceptionsMessageConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateIfNumbersDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.LOTTO_NUMBERS_COUNT_MUST_BE_SIX);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateIfNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.NUMBERS_CANNOT_BE_DUPLICATED);
        }

    }
}
