package lotto.repository;

import lotto.domain.WinningLotto;

public interface WinningLottoRepository {

    void save(WinningLotto winningLotto);

    WinningLotto findLast();
}
