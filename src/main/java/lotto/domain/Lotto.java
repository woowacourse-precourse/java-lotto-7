package lotto.domain;

import lotto.common.validator.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = createNumbers(numbers);
        LottoValidator.validate(this.numbers);
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private List<Number> createNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> new Number(String.valueOf(n)))
                .collect(Collectors.toList());
    }
}
