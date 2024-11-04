package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);

        if (isOutOfRange) {
            throw new IllegalArgumentException("숫자는 1에서 45 사이여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean isDuplicate = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicate) {
            throw new IllegalArgumentException("로또 번호가 중복되서는 안됩니다.");
        }
    }
}
