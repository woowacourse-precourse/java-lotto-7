package lotto.domain;

import java.util.List;

public class LottoRaffle {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoRaffle(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningLotto.getNumbers();
    }

}
