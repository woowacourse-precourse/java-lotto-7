package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class WinningNumbers {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int matchLotto(Lotto lotto) {
        List<Integer> resultList = lotto.getNumbers().stream()
                .filter(lo -> winningNumber.getNumbers().stream().anyMatch(Predicate.isEqual(lo)))
                            .toList();

        return resultList.size();
    }

}
