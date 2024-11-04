package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    Validation validation = new Validation();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        numbers = numbers.stream()
            .filter(validation::isPositive)
            .filter(validation::validateRange)
            .toList();
        validation.isUnique(numbers);
        validation.validateSize(numbers);
    }


}
