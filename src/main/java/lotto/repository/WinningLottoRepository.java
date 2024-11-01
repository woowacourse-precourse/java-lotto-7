package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class WinningLottoRepository {

    private WinningLotto winningLotto;

    public void createLotto(Lotto lotto) {
        winningLotto = new WinningLotto(lotto);
    }

    public void createBonusNumber(int bonusNumber) {
        winningLotto.setupBonusNumber(bonusNumber);
    }

    public WinningLotto get() {
        return winningLotto;
    }
}
