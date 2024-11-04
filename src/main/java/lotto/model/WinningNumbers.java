package lotto.model;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private static final String DELIMITER = ",";

    private final List<Integer> winningNumbers;

    private WinningNumbers(String userInputNumbers) {
        this.winningNumbers = parseNumbers(userInputNumbers);
    }

    public static WinningNumbers from(String userInputNumbers) {
        return new WinningNumbers(userInputNumbers);
    }

    private List<Integer> parseNumbers(String userInputNumbers) {
        return Arrays.stream(userInputNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

}
