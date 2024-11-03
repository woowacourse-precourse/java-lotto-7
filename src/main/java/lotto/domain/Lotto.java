package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.common.validator.LottoValidator;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = Set.copyOf(numbers);
    }

    public Set<Integer> getNumbers() {
        return Set.copyOf(numbers);
    }
}
