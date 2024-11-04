package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(List<Integer> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    public int size() {
        return winningNumbers.size();
    }

    public Integer get(int idx) {
        return winningNumbers.get(idx);
    }

    public boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }
}
