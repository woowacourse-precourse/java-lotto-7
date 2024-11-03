package lotto.domain.model;

import static lotto.domain.constant.LottoConstraintProperties.FIXED_LOTTO_SIZE;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String VIOLATION_FIXED_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String VIOLATION_UNIQUE_NUMBERS = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).toList();
    }

    public boolean isExist(LottoNumber bonus) {
        return this.numbers.stream().anyMatch(v -> v.equals(bonus));
    }

    public int match(Lotto other) {
        return (int) this.numbers.stream().
                filter(number -> other.isExist(number))
                .count();
    }

    @Override
    public String toString() {
        return this.numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private void validate(List<Integer> numbers) {
        verifyNumbersSize(numbers);
        verifyUniqueNumbers(numbers);
    }

    private static void verifyNumbersSize(List<Integer> numbers) {
        if (numbers.size() != FIXED_LOTTO_SIZE) {
            throw new IllegalArgumentException(VIOLATION_FIXED_SIZE);
        }
    }

    private static void verifyUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != FIXED_LOTTO_SIZE) {
            throw new IllegalArgumentException(VIOLATION_UNIQUE_NUMBERS);
        }
    }
}
