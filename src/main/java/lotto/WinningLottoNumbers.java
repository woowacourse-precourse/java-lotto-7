package lotto;

import java.util.List;

public class WinningLottoNumbers {
    private final List<Integer> numbers;

    public WinningLottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
    }

    private void validateSize(List<Integer> numbers) {
    }
}
