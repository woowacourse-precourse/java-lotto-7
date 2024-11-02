package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public void setWinningNumbers(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
