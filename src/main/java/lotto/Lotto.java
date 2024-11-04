package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int COUNTS_OF_LOTTO = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNTS_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        isDuplicate(numbers);
    }

    private void isDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != numbers.size()) {
            throw new IllegalStateException();
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
