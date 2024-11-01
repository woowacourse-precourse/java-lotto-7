package lotto.lotto;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new Lotto(winningNumbers);
    }

    public int countMatches(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().contains(number))
                .count();
    }

    public boolean containsNumber(Number number) {
        return winningNumbers.containsNumber(number);
    }
}
