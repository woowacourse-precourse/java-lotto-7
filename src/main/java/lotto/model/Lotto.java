package lotto.model;

import static lotto.message.ErrorMessage.LOTTO_SIZE_6;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_6.getMessage());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
