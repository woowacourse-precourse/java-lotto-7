package lotto.domain.repository;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoRepository {

    void saveAll(List<Lotto> lottos);

    List<Lotto> getAll();

    void clear();
}
