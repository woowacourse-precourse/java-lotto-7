package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!(numbers.stream().allMatch(num -> num >= 1 && num <= 45))) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 값이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (!(numbers.size() == new HashSet<>(numbers).size())) {
            throw new IllegalArgumentException("[ERROR] 중복된 값은 불가능합니다");
        }
    }
}
