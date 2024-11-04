package model;

import java.util.List;
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
        if (numbers.size() != 6 || isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
