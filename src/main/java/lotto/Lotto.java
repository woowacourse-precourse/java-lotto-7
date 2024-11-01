package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (numbers.size() != noDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
