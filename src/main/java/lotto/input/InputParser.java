package lotto.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(", "))
                .map(Integer::parseInt)
                .toList();
    }
}
