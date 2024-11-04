package lotto.repository;

import lotto.domain.lotto.WinningLotto;

public class WinningLottoRepository {

    private WinningLotto winningLotto = new WinningLotto();

    public WinningLotto get() {
        return winningLotto;
    }
}
