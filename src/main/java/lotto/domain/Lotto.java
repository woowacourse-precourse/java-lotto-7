package lotto.domain;

import java.util.List;
import lotto.validation.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLotto(numbers);
    }

    public int countMatchingNumbers(List<Integer> winninNumbers) {
        return (int) numbers.stream()
                .filter(winninNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
