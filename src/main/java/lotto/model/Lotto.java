package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public String toString() {
        return numbers.toString();
    }
}
