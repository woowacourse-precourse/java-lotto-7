package lotto.domain;

import lotto.util.LottoValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.run(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
