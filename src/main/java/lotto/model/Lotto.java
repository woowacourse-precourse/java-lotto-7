package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public long getMatchNumbersCount(Lotto compare) {
        Set<Integer> matchingChecker = new HashSet<>(numbers);
        return compare.getNumbers().stream().filter(number -> !matchingChecker.add(number)).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
