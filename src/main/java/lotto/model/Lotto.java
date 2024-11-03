package lotto.model;

import java.util.List;
import lotto.exception.ErrorCode;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException( "[ERROR] " + ErrorCode.INVALID_LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
