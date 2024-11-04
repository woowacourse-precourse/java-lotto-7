package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueElements(numbers);
        validateLimitRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateUniqueElements(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(); // 고유 숫자를 저장할 Set

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {  // 중복된 숫자가 있으면 예외 발생
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다: " + number);
            }
        }
    }

    private void validateLimitRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
