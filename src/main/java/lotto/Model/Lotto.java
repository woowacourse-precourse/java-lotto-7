package lotto.Model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() > uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 겹치지 않아야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (Collections.max(numbers) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 최대값은 45 이하여야 합니다.");
        }
        if(Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 최소값은 1 이상이어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
