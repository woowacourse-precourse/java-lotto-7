package lotto.domain;

import java.util.List;
import lotto.util.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateSize(numbers);
        LottoValidator.validateDuplicateNumbers(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
