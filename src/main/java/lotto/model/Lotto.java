package lotto.model;

import java.util.List;
import lotto.util.Config;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Config.ERROR_INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
