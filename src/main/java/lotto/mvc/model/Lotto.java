package lotto.mvc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validation.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.isValid(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> copyOfNumbers = new ArrayList<>(numbers);
        Collections.sort(copyOfNumbers);
        return copyOfNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
