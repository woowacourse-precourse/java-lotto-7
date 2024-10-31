package lotto.domain;

import static lotto.common.Constants.LOTTO_MAX_NUMBER;
import static lotto.common.Constants.LOTTO_MIN_NUMBER;
import static lotto.common.Constants.LOTTO_NUMBER_MAX_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_MAX_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
