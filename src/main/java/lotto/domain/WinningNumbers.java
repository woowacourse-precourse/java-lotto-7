package lotto.domain;

import lotto.common.validator.LottoValidator;
import lotto.common.validator.NumberValidator;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Number> numbers;

    public WinningNumbers(List<String> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers.stream()
                .map(s -> new Number(s))
                .collect(Collectors.toList());
    }
}
