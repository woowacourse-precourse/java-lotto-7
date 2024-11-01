package lotto;

import static lotto.exception.ErrorMessage.INVALID_LOTTO_COUNTS;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_LOTTO_COUNTS);
        }
    }

    }

    // TODO: 추가 기능 구현
}
