package lotto.collection;

import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(String[] winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = convertStringToInteger(winningNumbers);
    }

    private void validate(String[] numbers) {
        Validator.checkWinningNumbers(numbers);
    }

    private List<Integer> convertStringToInteger(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
