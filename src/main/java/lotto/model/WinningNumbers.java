package lotto.model;

import java.util.List;
import lotto.utils.Converter;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    private WinningNumbers(String winningNumbers) {
        List<String> winningNumberStrings = splitInput(winningNumbers);
        this.winningNumbers = Converter.parseToIntegerList(winningNumberStrings);
    }

    public static WinningNumbers from(String winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    private List<String> splitInput(String input) {
        return List.of(input.split(","));
    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumbers);
    }
}
