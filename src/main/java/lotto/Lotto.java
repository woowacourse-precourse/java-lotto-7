package lotto;

import java.util.Comparator;
import java.util.List;

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
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        sort(this.numbers);
        return numbers;
    }

    @Override
    public String toString() {
        sort(this.numbers);
        return numbers.toString();
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
