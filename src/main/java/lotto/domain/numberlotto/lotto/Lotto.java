package lotto.domain.numberlotto.lotto;

import lotto.domain.numberlotto.constants.message.InputError;
import lotto.domain.numberlotto.constants.message.RangeError;
import lotto.domain.numberlotto.constants.value.LottoRule;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {

        validateLength(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoRule.COMBINATION_LENGTH.getValue()) {
            System.out.println(RangeError.LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            System.out.println(InputError.DUPLICATE_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
