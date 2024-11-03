package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !isInRange(number))) {
            throw new IllegalArgumentException("[ERROR] 숫자가 유효 범위를 벗어났습니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().anyMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private boolean isInRange(int number) {
        return (number >= 0) && (number <= 45);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    // TODO: 추가 기능 구현
}
