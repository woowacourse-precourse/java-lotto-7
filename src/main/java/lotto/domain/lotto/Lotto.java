package lotto.domain.lotto;

import static lotto.resources.Constants.LOTTO_TOTAL_NUMBERS;
import static lotto.resources.ErrorMessages.DUPLICATE_LOTTO_NUMBER;
import static lotto.resources.ErrorMessages.INVALID_LOTTO_TOTAL_NUMBER;

import java.util.List;
import java.util.Objects;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;

public class Lotto {
    private final Numbers numbers;

    Lotto(final Numbers numbers) {
        validate(numbers);
        this.numbers = sortAscendingLotto(numbers);
    }

    private void validate(final Numbers numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersSize(final Numbers numbers) {
        if (numbers.getNumbers().size() != LOTTO_TOTAL_NUMBERS) {
            throw new IllegalArgumentException(INVALID_LOTTO_TOTAL_NUMBER.getMessage());
        }
    }

    private void validateDuplicateNumbers(final Numbers numbers) {
        long sizeWithOutDuplicate = numbers.getNumbers().stream()
                .distinct()
                .count();

        if (numbers.getNumbers().size() != sizeWithOutDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private Numbers sortAscendingLotto(final Numbers numbers) {
        List<Integer> sortedNumbers = numbers.getNumbers().stream()
                .map(Number::getNumber)
                .sorted()
                .toList();

        return Numbers.of(sortedNumbers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) obj;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        String numbers = this.numbers.getNumbers().stream().
                map(Number::getNumber)
                .toList().
                toString();
        
        return numbers + "\n";
    }
}
