package lotto;

import Common.Validator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
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
