package lotto.domain;

import lotto.util.LottoConstant;
import lotto.util.LottoNumberValidator;

import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateSize(numbers);
        LottoNumberValidator.validateNumbersInRange(numbers);
        LottoNumberValidator.validateDuplicates(numbers);
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
