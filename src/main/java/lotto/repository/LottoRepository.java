package lotto.repository;

import java.util.List;
import lotto.model.domain.Lotto;

public interface LottoRepository {
    void save(Lotto lotto);

    List<Lotto> findAllLotto();

    void clear();
}
