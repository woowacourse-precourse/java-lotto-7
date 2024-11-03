package lotto.repository.mock;

import java.util.Optional;
import lotto.domain.LottoList;
import lotto.repository.SingleRepository;

public class MockLottoListRepository implements SingleRepository<LottoList> {

    private LottoList lottoList;

    public MockLottoListRepository(LottoList lottoList) {
        this.lottoList = lottoList;
    }

    public MockLottoListRepository() {
    }

    @Override
    public LottoList save(LottoList object) {
        return object;
    }

    @Override
    public Optional<LottoList> get() {
        return Optional.ofNullable(lottoList);
    }
}
