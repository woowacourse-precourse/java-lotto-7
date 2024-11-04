package lotto.domain;

import static lotto.common.ExceptionMessage.*;
import static lotto.common.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.common.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.common.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int calculateMatchingCount(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_SIZE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);

        if (isOutOfRange) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean isDuplicate = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicate) {
            throw new IllegalArgumentException(NO_LOTTO_NUMBER_DUPLICATION);
        }
    }
}
