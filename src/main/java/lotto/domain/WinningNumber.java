package lotto.domain;

import java.util.Set;

public class WinningNumber {
    private static Set<Integer> winningNumbers;

    public WinningNumber(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
