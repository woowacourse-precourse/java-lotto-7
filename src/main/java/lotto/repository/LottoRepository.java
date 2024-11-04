package lotto.repository;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoRepository {

    void saveAll(List<Lotto> lottoList);

    List<Lotto> findAll();
}
