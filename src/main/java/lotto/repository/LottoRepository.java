package lotto.repository;

import java.util.List;
import lotto.model.Lotto;

public interface LottoRepository {

    void save(Lotto lotto);

    int count();

    List<Lotto> findAll();
}
