package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        validateDuplicateValue(numbers);
    }

    private void validateDuplicateValue(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 넣을 수 없습니다.");
        }
    }

    public void printCurrentStatus() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
