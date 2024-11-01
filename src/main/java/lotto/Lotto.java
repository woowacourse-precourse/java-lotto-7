package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isNotRange = numbers.stream().anyMatch(num -> num < 1 || num > 45);
        if (isNotRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        boolean isDuplicated = new HashSet<>(numbers).size() != numbers.size();
        if (isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어선 안됩니다.");
        }
    }

}
