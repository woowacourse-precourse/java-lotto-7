package lotto.domain.lotto;

import lotto.domain.constants.LottoRule;
import lotto.domain.errors.RangeError;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto extends NumberCombination{

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(LottoRule.COMBINATION_LENGTH.getValue(),numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
