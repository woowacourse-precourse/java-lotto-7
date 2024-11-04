package lotto.model.win;

import java.util.List;
import lotto.util.Validator;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        Validator.checkWinningNumbersCount(numbers);
        Validator.checkWinningNumbersDuplicate(numbers);
        Validator.checkWinningNumbersRange(numbers);
    }

    public List<Integer> get() {
        return numbers;
    }
}
