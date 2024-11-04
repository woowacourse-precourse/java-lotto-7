package lotto.model;

import static lotto.model.Lotto.MAX_RANGE;
import static lotto.model.Lotto.MAX_SIZE;
import static lotto.model.Lotto.MIN_RANGE;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        numbers.forEach(this::validateRange);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != MAX_SIZE) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> get() {
        return List.copyOf(numbers);
    }

    private void validateRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException("번호는 1에서 45 사이여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("담청 번호는 6자리 입니다.");
        }
    }
}