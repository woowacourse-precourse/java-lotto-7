package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkSame(numbers);
        checkRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void checkSame(List<Integer> numbers) {
        Set<Integer> numberSize = new HashSet<>(numbers);
        if (numbers.size() != numberSize.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException("로또 번호는 1 에서 45 사이로 작성해 주세요");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
