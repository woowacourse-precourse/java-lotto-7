package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        List<String> winningNumberStrings = splitInput(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private List<String> splitInput(String input) {
        return List.of(input.split(","));
    }


}
