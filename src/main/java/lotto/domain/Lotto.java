package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != getDistinctSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private int getDistinctSize(List<Integer> numbers) {
        return (int) numbers.stream()
            .distinct()
            .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto getSortedLotto() {
        ArrayList<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);
        return new Lotto(newNumbers);
    }
}
