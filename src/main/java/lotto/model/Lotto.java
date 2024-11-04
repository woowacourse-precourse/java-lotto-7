package lotto.model;

import java.util.List;
import lotto.validation.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;
    private static final LottoNumberValidator validator = new LottoNumberValidator();

    public Lotto(List<Integer> numbers) {
        validator.validate(numbers);
        this.numbers = List.copyOf(numbers.stream().sorted().toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
