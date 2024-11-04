package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
        validateNumberRange(numbers);
        validateUniqueNumber(numbers);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
}