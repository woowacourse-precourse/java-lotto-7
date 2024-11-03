package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream().
                filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                });
    }

    public List<Integer> numbers() {
        return this.numbers;
    }
}
