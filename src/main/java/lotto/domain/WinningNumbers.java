package lotto.domain;

import lotto.common.validator.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Number> numbers;

    public WinningNumbers(List<String> numbers) {
        this.numbers = createNumbers(numbers);
        LottoValidator.validate(this.numbers);
    }

    private List<Number> createNumbers(List<String> numbers) {
        return numbers.stream()
                .map(s -> new Number(s))
                .collect(Collectors.toList());
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}