package lotto.model;

import lotto.utils.LottoValidator;
import lotto.utils.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    Validator<List<Integer>> validator;

    public Lotto(List<Integer> numbers) {
        validator = new LottoValidator();
        validator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
