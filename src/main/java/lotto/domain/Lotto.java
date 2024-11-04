package lotto.domain;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.MessageContainer.COUNT_OF_LOTTO_NUMBERS_ERROR;
import static lotto.MessageContainer.DUPLICATE_NUMBER_ERROR;
import static lotto.MessageContainer.OUT_OF_RANGE_NUMBER_ERROR;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSizeOf(numbers);
        validateNoDuplicatesIn(numbers);
        validateRangeOfNumbersIn(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    public int countMatchingNumbersWith(Lotto other) {
        return (int) other.numbers.stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    private void validateSizeOf(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(COUNT_OF_LOTTO_NUMBERS_ERROR);
        }
    }

    private void validateNoDuplicatesIn(List<Integer> numbers) {
        long sizeExcludingDuplicateNumbers = numbers.stream().distinct().count();
        if (numbers.size() != sizeExcludingDuplicateNumbers) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private void validateRangeOfNumbersIn(List<Integer> numbers) {
        if (!numbers.stream().allMatch(this::verifyInLottoNumberRange)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR);
        }
    }

    private boolean verifyInLottoNumberRange(Integer number) {
        return (number >= MIN_LOTTO_NUMBER) && (number <= MAX_LOTTO_NUMBER);
    }

    @Override
    public String toString() {
        return numbers.toString().concat(System.lineSeparator());
    }
}
