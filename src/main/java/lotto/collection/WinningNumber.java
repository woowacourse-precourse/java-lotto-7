package lotto.collection;

import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber(String[] winningNumbers) {
        validate(winningNumbers);
        this.numbers = convertStringToInteger(winningNumbers);
    }

    private void validate(String[] numbers) {
        Validator.checkWinningNumbers(numbers);
    }

    private List<Integer> convertStringToInteger(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
