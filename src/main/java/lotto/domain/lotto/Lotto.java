package lotto.domain.lotto;

import lotto.domain.constants.LottoRule;
import lotto.domain.errors.RangeError;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.COMBINATION_LENGTH.getValue()) {
            System.out.println(RangeError.LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }

}
