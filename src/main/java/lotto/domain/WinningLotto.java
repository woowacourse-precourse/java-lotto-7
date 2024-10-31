package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winLotto;
    private final Integer bonusNumber;

    protected WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, Integer bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
