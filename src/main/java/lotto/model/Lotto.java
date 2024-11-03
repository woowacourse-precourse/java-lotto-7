package lotto.model;

import static lotto.Constants.LOTTO_MAX_NUMBER;
import static lotto.Constants.LOTTO_MIN_NUMBER;
import static lotto.Constants.LOTTO_SIZE;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (hasInvalidSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (hasInvalidRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private static boolean hasInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private static boolean hasInvalidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER);
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != LOTTO_SIZE;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public long getMatchCount(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
