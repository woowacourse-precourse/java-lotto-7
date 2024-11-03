package lotto.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private final List<Integer> WINNING_LOTTO;

    public InputParser(String winningNumbers) {
        this.WINNING_LOTTO = splitWinningNumbers(winningNumbers);
    }
    public List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
