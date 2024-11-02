package domain;

import static utils.NumberValidation.*;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private Lotto(List<Integer> numbers) {
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
