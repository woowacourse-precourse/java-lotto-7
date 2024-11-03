package lotto.domain;

import static lotto.validation.NumberValidation.validateDuplicateNumber;
import static lotto.validation.NumberValidation.validateNumberRange;
import static lotto.validation.NumberValidation.validateNumberSize;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
        validateNumberSize(numbers);
    }

}
