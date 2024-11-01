package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateUnderZero(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnderZero(List<Integer> numbers) {
        boolean hasZero = numbers.stream()
                .anyMatch(num -> num <= 0);

        if (hasZero) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 0이 포함될 수 없습니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();

        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 뽑으실 수 없습니다.");
        }
    }

}
