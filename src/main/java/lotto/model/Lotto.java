package lotto.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateIsDuplicated(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateIsDuplicated(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void sort(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
