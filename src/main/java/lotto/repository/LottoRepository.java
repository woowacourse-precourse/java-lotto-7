package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoRepository {

    void save(Lotto lotto);
    List<Lotto> findAll();

    int getAmount();

}
