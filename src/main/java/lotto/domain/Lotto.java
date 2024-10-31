package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;

public class Lotto {

    private static final int LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_NOT_SIX.getMessage());
        }
    }
}
