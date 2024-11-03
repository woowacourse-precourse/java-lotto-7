package lotto.model;

import static lotto.constant.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_RANGE;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_SIZE;
import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.VALID_SIZE;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (hasInvalidSize(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
        if (hasInvalidRange(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean hasInvalidSize(List<Integer> numbers) {
        return numbers.size() != VALID_SIZE.getValue();
    }

    private static boolean hasInvalidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n < MIN_NUMBER.getValue() || n > MAX_NUMBER.getValue());
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != VALID_SIZE.getValue();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public long getMatchCount(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
