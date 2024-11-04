package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_NUMBER_EXISTS;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXISTS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
