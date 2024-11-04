package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        List<Integer> duplicate = new ArrayList<>(set);
        if (duplicate.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
        }
    }
}
