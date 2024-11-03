package lotto;

import lotto.validator.LottoNumberValidator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final LottoNumberValidator validator;

    public Lotto(List<Integer> numbers) {
        this.validator = new LottoNumberValidator(numbers);
        this.numbers = numbers;
        sort();
        validate();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate() {
        validator.validate();
    }

    private void sort(){
        Collections.sort(numbers);
    }
}
