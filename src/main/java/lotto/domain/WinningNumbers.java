package lotto.domain;

import java.util.List;
import lotto.utils.Converter;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        List<String> winningNumberStrings = splitInput(winningNumbers);
        this.winningNumbers = Converter.parseToIntegerList(winningNumberStrings);
    }

    private List<String> splitInput(String input) {
        return List.of(input.split(","));
    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumbers);
    }
}
