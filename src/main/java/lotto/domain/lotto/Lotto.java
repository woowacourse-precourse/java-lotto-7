package lotto.domain.lotto;

import lotto.domain.constants.message.InputError;
import lotto.domain.constants.message.RangeError;
import lotto.domain.constants.value.LottoRule;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoRule.COMBINATION_LENGTH.getValue()) {
            System.out.println(RangeError.LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            System.out.println(InputError.DUPLICATE_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
