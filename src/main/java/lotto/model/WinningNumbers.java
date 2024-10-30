package lotto.model;

import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.winningNumbers = numbers;
    }
    private void validate(List<Integer> numbers) {
    }
}
