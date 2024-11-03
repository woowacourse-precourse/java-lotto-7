package lotto.entity;

import lotto.validator.Validator;
import lotto.validator.entity.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private final Validator validator;

    public Lotto(List<Integer> numbers) {
        this.validator = new LottoValidator(numbers);
        validate();
        this.numbers = sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate() {
        validator.validate();
    }

    private List<Integer> sort(List<Integer> numbers){
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
