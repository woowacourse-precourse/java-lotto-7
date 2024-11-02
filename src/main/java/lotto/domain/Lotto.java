package lotto.domain;

import java.util.Collections;
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

    public List<Integer> numberSort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public String lottoValue() {
        return numbers.toString();
    }
}
