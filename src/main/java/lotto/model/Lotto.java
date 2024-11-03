package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String ERROR_INVALID_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBERS = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicates(numbers);
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<?> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
