package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.LottoList;
import lotto.repository.SingleRepository;

public class LottoListRepository implements SingleRepository<LottoList> {

    private LottoList lottoList;

    @Override
    public LottoList save(LottoList lottoList) {
        this.lottoList = lottoList;
        return this.lottoList;
    }

    @Override
    public Optional<LottoList> get() {
        return Optional.ofNullable(lottoList);
    }
}
