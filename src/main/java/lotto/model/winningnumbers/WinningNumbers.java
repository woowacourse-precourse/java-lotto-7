package lotto.model.winningnumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String SEPARATOR = ",";

    private List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbersInput) {
        this.winningNumbers = parseWinningNumbers(winningNumbersInput);
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> get() {
        return winningNumbers;
    }
}
