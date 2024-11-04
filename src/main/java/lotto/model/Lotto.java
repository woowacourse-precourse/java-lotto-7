package lotto.model;

import lotto.util.Validator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateLottoSize(numbers);
        Validator.validateNoDuplicates(numbers);

        for (Integer number : numbers) {
            Validator.validateLottoRange(number);
        }
    }

    public String getLottoNumbers() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    public int countCorrectNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int input) {
        return numbers.contains(input);
    }
}
