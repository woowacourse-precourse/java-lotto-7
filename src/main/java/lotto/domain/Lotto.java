package lotto.domain;

import java.util.List;
import lotto.error.ErrorCode;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
