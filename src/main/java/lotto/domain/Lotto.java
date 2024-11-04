package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;
import lotto.validator.LottoValidator;

public class Lotto {
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            LottoException.throwInvalidSizeException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != REQUIRED_NUMBER_COUNT) {
            LottoException.throwDuplicateNumberException();
        }
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) numbers.stream()
            .filter(otherLotto.getNumbers()::contains)
            .count();
    }
}
