package lotto.domain.repository;

import lotto.domain.WinLotto;

public interface WinLottoRepository {

    void save(WinLotto winLotto);

    WinLotto getRecent();

    void clear();
}
