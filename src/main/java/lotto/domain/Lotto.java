package lotto.domain;


import java.util.HashSet;
import java.util.List;
import lotto.utils.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE);
        }

        boolean isDuplicate = numbers.size() != new HashSet<>(numbers).size();
        if (isDuplicate) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
