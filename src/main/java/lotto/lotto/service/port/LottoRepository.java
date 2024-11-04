package lotto.lotto.service.port;

import lotto.lotto.domain.LottoResults;

public interface LottoRepository {
    LottoResults save(LottoResults lottoResults);

    LottoResults findById(String id);
}
