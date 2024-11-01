package lotto.core.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateDuplicated(numbers);
        validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean notInRange = numbers.stream().anyMatch(number -> number > 45 || number < 1);
        if (notInRange) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자만 가능합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
