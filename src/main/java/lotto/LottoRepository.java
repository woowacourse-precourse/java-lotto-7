package lotto;

import java.util.List;

public interface LottoRepository {

    void saveAll(List<Lotto> lottos);

    List<Lotto> getAll();
}
