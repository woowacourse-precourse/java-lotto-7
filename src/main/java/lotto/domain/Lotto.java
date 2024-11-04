package lotto.domain;

import java.util.List;
import lotto.utils.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateIsDuplicate(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.numbersLength(numbers);
    }

    private void validateIsDuplicate(List<Integer> numbers) {
        Validator.numberDuplicate(numbers);
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(Validator::numberInRange);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
