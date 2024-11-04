package lotto.domain;

import java.util.List;
import lotto.domain.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
