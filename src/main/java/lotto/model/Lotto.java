package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateEachNumber(numbers);
        validateSameNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    // 숫자 하나씩 검증
    private void validateEachNumber(List<Integer> numbers) {
        System.out.println("개별번호");
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateSameNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int compareNumbers(Lotto other) {
        List<Integer> otherNumbers = other.getNumbers();
        int count = 0;

        for (Integer number : numbers) {
            if (otherNumbers.contains(number)) count++;
        }
        return count;
    }
}
