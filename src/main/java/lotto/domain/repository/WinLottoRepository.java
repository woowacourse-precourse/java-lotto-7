package lotto.domain.repository;

import lotto.application.service.WinLotto;

public interface WinLottoRepository {

    void save(WinLotto winLotto);

    WinLotto getRecent();

    void clear();
}
