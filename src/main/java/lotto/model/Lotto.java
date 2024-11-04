package lotto.model;

import lotto.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.Constants.*;

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
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != PICK_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (!(MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 1 ~ 45 사이의 수가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != PICK_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 번호가 중복되는 로또 번호가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public String toString() {
        return numbers.toString();
    }
}
