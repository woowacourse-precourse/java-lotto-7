package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있을 수 없습니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers).size() < numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
