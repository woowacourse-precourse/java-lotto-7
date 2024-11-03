package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = sortInAscendingOrder(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateHasDuplicateNumber(numbers);
    }

    private List<Integer> sortInAscendingOrder(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateHasDuplicateNumber(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        return numberSet.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
