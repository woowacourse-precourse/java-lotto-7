package lotto.domain;

import java.util.List;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateWinningNumber(numbers);
    }

    public List<Integer> getSortedNumbers(){
        return numbers.stream()
                .sorted()
                .toList();
    }
}
