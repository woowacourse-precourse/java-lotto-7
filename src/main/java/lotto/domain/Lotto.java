package lotto.domain;

import lotto.util.LottoValidate;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidate.validate(numbers);
    }

    public List<Integer> numbers() {
        return numbers;
    }

}
