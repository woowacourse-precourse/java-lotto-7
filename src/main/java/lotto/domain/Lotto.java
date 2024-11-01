package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto implements Lottery {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public void sort() {
        Collections.sort(numbers);
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

}
