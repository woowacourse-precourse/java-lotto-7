package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        numbers.stream()
                .distinct()
                .findFirst()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복값이 허용되지 않습니다.");
                });
    }
}
