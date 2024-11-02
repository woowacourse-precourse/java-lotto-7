package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winLotto;
    private final Integer bonusNumber;

    protected WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        this.winLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, Integer bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
