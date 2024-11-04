package lotto.domain;

public class WinningLotto {
    private final Lotto winningNumbers;

    public WinningLotto(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }
}
