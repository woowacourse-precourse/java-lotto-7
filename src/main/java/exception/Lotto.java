package exception;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int DEFAULT = 0;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        negativeValidate(numbers);
        duplicateValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        emptyValidate(numbers);
        this.numbers = List.of(DEFAULT);
    }

    private void emptyValidate(String numbers) {
        if (numbers.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 비어있습니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void negativeValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상이어야 합니다.");
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number > LOTTO_MAX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 45 이하이어야 합니다.");
        }
    }
}
