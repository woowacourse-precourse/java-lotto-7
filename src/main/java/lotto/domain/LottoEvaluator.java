package lotto.domain;

import java.util.List;

public class LottoEvaluator {

    private final WinningNumbers winningNumbers;

    public LottoEvaluator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getMatchingCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
            .filter(winningNumbers.getWinningNumbers()::contains)
            .count();
    }

    public boolean containsBonus(Lotto lotto) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber().getNumber());
    }
}
