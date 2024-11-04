package lotto.model;

import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int SIZE_OF_DEFAULT_NUMBERS = 6;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE_OF_DEFAULT_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE_OF_DEFAULT_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LOTTO_START_NUMBER || n > LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
