package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.view.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Error.reject(Error.FIXED_COUNT_MSG);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
