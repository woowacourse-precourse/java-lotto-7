package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;

    public WinningLotto(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
}

    public List<Integer> getWinningNumbers() {
        return winningLotto.getNumbers();
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(getWinningNumbers()::contains)
                .count();
    }
}
