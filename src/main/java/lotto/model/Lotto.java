package lotto.model;

import java.util.List;
import java.util.function.Predicate;

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
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 말아야 합니다.");
        }
    }

    public boolean isNumbersContains(int otherNumber) {
        return numbers.contains(otherNumber);
    }

    public List<Integer> getMatchedNumbers(List<Integer> compareNumbers) {
        return numbers.stream().filter(number -> compareNumbers.stream().anyMatch(Predicate.isEqual(number))).toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
