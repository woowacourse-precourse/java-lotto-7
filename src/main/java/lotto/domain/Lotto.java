package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<Integer> {
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

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
