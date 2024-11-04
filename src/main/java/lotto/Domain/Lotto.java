package lotto.Domain;

import lotto.Common.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateNumbersCount(numbers);
        Validator.validateNumbers(numbers);
        Validator.validateDuplicateNumber(numbers);
    }
    public int countMatchedNumber(List<Integer> winningNumbers) {
        int count = 0;
        for (int i : winningNumbers) {
            if (numbers.contains(i)) count++;
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
