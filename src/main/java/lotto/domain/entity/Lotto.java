package lotto.domain.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lotto implements Iterable<Integer> {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isBoundedNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 정수입니다.");
        }

        if (isSixNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (isValidFalse(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능 합니다.");
        }
    }

    private boolean isBoundedNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number < 1 && number > 45);
    }

    private boolean isSixNumbers(final List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isValidFalse(final List<Integer> numbers) {
        final Set<Integer> setNumbers = new HashSet<>(numbers);
        return setNumbers.size() != numbers.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.numbers.iterator();
    }
}
