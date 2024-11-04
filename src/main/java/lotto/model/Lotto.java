package lotto.model;

import java.util.List;
import java.util.function.Predicate;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new LottoNumbersValidator(numbers);
        validator.validate();
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
