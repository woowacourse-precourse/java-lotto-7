package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<Number> numbers;

    public Lotto(List<Integer> i_numbers) {
        Set<Number> numbers = new HashSet<>(i_numbers.stream().map(Number::new).toList());
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
