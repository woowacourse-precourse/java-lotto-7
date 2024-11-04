package lotto.Model;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호끼리 중복될 수 없습니다.");
        }
        if (!isInValidateRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private boolean isInValidateRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}