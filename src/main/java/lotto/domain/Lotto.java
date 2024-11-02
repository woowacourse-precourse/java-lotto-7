package lotto.domain;

import static lotto.domain.constant.LottoConstraint.FIXED_LOTTO_SIZE;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final String VIOLATION_FIXED_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String VIOLATION_UNIQUE_NUMBERS = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != FIXED_LOTTO_SIZE) {
            throw new IllegalArgumentException(VIOLATION_FIXED_SIZE);
        }

        if (numbers.stream().distinct().count() != FIXED_LOTTO_SIZE) {
            throw new IllegalArgumentException(VIOLATION_UNIQUE_NUMBERS);
        }
    }

    @Override
    public String toString() {
        return this.numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
