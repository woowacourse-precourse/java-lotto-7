package lotto.input;

import static lotto.constants.ErrorMessage.LOTTO_DUPLICATION_ERROR;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> duplicate = new HashSet<>(numbers);
        if (duplicate.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_ERROR.getMessage());
        }
    }
}
