package lotto.domain.repository;

import lotto.domain.WinLotto;

public class WinLottoRepository {

    private WinLotto winLotto;

    public void add(WinLotto addWinLotto) {
        winLotto = addWinLotto;
    }

    public WinLotto getWinLotto() {
        if (winLotto == null) {
            throw new NullPointerException("winLotto 를 설정 해야합니다.");
        }

        return winLotto;
    }
}
