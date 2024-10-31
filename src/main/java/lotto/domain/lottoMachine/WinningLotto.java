package lotto.domain.lottoMachine;

import lotto.domain.lotto.Lotto;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final Lotto winningLotto, final BonusNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
