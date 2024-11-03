package lotto.model;

import java.util.Arrays;
import java.util.List;

public class WinningNumberGenerator {
    public Lotto createWinningNumbers(String rawWinningNumbers) {
        List<String> winningNumbers = splitWinningNumbers(rawWinningNumbers);
        List<Integer> numbers = convertWinningNumbers(winningNumbers);
        return Lotto.createWinningLotto(numbers);
    }

    private List<String> splitWinningNumbers(String rawWinningNumbers) {
        return Arrays.asList(rawWinningNumbers.split(","));
    }

    private List<Integer> convertWinningNumbers(List<String> rawWinningNumbers) {
        return rawWinningNumbers.stream().map(Integer::parseInt).toList();
    }
}
