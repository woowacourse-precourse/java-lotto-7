package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
