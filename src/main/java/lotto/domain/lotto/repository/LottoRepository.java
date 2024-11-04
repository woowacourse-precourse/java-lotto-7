package lotto.domain.lotto.repository;

import java.util.List;
import java.util.UUID;
import lotto.domain.lotto.Lotto;

public interface LottoRepository {

    void save(Lotto lotto);

    List<Lotto> findAll();

    void saveAll(List<Lotto> lottos);
}
