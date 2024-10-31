package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator<List<Integer>> validator = new LottoValidator();
        validator.validate(numbers);
    }

    // TODO: 추가 기능 구현
}
