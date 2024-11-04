package lotto.domain.lotto.repository;

import java.util.List;
import lotto.domain.lotto.Lotto;

public interface LottoRepository {

    void save(Lotto lotto);

    List<Lotto> findAll();
}
