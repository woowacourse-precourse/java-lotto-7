package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoRepository {
    Lotto save(Lotto lotto);

    Lotto findWinningNums();
}
