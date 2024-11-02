package lotto.repository;

import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;

public interface LottoRepository {

    void save(Lotto lotto);

    List<Lotto> findAll();

    void deleteAll();
}
