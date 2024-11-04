package lotto.model;

import java.util.List;
import lotto.controller.InputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        InputValidator validate = new InputValidator();
        validate.validateWinningNumbers(numbers);
        this.numbers = numbers.stream().distinct().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
