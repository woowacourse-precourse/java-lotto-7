package lotto.domain;

import java.util.function.Predicate;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(Number -> winningNumber.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(Number)))
                .count();
    }
}
