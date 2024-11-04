package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호를 입력할 수 없습니다.");
        }
    }

    public int getDuplicateNumbers(Lotto lotto) {
        Set<Integer> set1 = new HashSet<>(this.numbers);
        Set<Integer> set2 = new HashSet<>(lotto.numbers);

        set1.retainAll(set2);

        return set1.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
