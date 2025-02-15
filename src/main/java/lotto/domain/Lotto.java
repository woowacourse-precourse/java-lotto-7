package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, LottoValidator validator) {
        validate(numbers, validator);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, LottoValidator validator) {
        validator.validate(numbers);
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
