package lotto.domain;

import lotto.domain.lotto.Lotto;

public class WinningNumbers {

    private final Lotto winningNumbers;

    private WinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(Lotto winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    public boolean contains(Number target) {
        return winningNumbers.contains(target);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }
}
