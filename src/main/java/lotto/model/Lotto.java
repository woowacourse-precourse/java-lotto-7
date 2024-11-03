package lotto.model;

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
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호는 허용하지 않습니다.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
