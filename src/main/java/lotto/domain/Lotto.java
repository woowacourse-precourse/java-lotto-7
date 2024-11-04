package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import static lotto.common.constant.LottoErrorCode.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw INVALID_NUMBER_COUNT.throwError();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER)) {
            throw INVALID_NUMBER_RANGE.throwError();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw NUMBER_DUPLICATE.throwError();
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean matchBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private boolean contains(Integer number) {
        return numbers.contains(number);
    }
}