package lotto.domain;

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

        boolean isDuplicate = numbers.size() != new HashSet<>(numbers).size();
        if (isDuplicate) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다!");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}