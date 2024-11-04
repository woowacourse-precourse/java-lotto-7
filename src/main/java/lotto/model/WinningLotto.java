package lotto.model;

import java.util.List;

public class WinningLotto{
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchWinningNumber(List<Integer> numbers) {
        return lotto.matchNumber(numbers);
    }

    public boolean matchBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
