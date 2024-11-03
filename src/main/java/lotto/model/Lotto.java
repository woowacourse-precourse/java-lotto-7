package lotto.model;

import lotto.validator.model.LottoNumberValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private final LottoNumberValidator validator;

    public Lotto(List<Integer> numbers) {
        this.validator = new LottoNumberValidator(numbers);
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
