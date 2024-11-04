package lotto.model;

import static lotto.validator.LottoNumberValidator.validateDuplicate;
import static lotto.validator.LottoNumberValidator.validateRange;
import static lotto.validator.LottoNumberValidator.validateSize;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
