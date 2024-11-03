package lotto.domain;

import java.util.stream.Collectors;
import java.util.List;
import lotto.validation.LottoValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = numberSort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidation.lottoValidation(numbers);
    }

    private List<Integer> numberSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public String lottoValue() {
        return numbers.toString();
    }

    public List<Integer> lottoNumbers() {
        return numbers;
    }
}
