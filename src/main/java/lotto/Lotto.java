package lotto;

import exception.LottoArgumentException;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(final List<Integer> numbers) {
        final Long elementCount = numbers.stream()
                .distinct()
                .count();
        if (elementCount != numbers.size()) {
            throw new LottoArgumentException("로또 번호는 중독되어선 안됩니다.");
        }
    }

    private void validateNumberRange(final List<Integer> range) {
        final boolean outOfRange = range.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (outOfRange) {
            throw new LottoArgumentException("로또 숫자 범위를 벗어났습니다.");
        }
    }
}
