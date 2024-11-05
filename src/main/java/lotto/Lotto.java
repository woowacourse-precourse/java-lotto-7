package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_NUMBERS.getMessage());
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_WINNING_NUMBER.getMessage());
        }

        for (Integer number : numbers) {
            validateNumberRange(number); // 범위 유효성 검사 호출
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
