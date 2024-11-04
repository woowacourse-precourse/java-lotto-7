package lotto.entity;

import java.util.List;
import lotto.exception.ErrorStatus;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        // 로또 갯수 체크
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_COUNT_OF_LOTTO_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
