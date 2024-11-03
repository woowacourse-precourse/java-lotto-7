package lotto.temp;

import java.util.Arrays;
import java.util.List;

public class Winning {
    public List<Integer> createWinningNumbers(String rawWinningNumbers) {
        List<String> winningNumbers = splitWinningNumbers(rawWinningNumbers);
        return convertWinningNumbers(winningNumbers);
    }

    private List<String> splitWinningNumbers(String rawWinningNumbers) {
        return Arrays.asList(rawWinningNumbers.split(","));
    }

    private List<Integer> convertWinningNumbers(List<String> rawWinningNumbers) {
        return rawWinningNumbers.stream().map(Integer::parseInt).toList();
    }
}
