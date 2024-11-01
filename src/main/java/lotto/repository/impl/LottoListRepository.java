package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.LottoList;
import lotto.repository.SingleRepository;

public class LottoListRepository implements SingleRepository<LottoList> {

    private LottoList lottoList;

    @Override
    public void save(LottoList object) {
        this.lottoList = object;
    }

    @Override
    public Optional<LottoList> get() {
        return Optional.ofNullable(lottoList);
    }
}
