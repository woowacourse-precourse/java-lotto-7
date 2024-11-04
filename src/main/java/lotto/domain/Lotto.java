package lotto.domain;

import lotto.util.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final LottoValidator validator;

    public Lotto(List<Integer> numbers) {
        this.validator = new LottoValidator();
        validator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
