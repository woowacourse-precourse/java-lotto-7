package lotto.model;

import lotto.utils.validator.LottoValidator;
import lotto.utils.validator.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Validator<List<Integer>> validator;

    public Lotto(List<Integer> numbers) {
        validator = new LottoValidator();
        validator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
