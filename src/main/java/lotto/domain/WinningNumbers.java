package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        List<String> winningNumberStrings = splitInput(winningNumbers);
        this.winningNumbers = parseToIntegerList(winningNumberStrings);
    }

    private List<String> splitInput(String input) {
        return List.of(input.split(","));
    }

    private List<Integer> parseToIntegerList(List<String> winningNumberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : winningNumberStrings) {
            numbers.add(Integer.parseInt(numStr.trim()));
        }
        return numbers;
    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumbers);
    }
}
