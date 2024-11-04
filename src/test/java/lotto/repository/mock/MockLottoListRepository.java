package lotto.repository.mock;

import java.util.Optional;
import lotto.domain.LottoTickets;
import lotto.repository.SingleRepository;

public class MockLottoListRepository implements SingleRepository<LottoTickets> {

    private LottoTickets lottoTickets;

    public MockLottoListRepository(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public MockLottoListRepository() {
    }

    @Override
    public LottoTickets save(LottoTickets object) {
        return object;
    }

    @Override
    public Optional<LottoTickets> get() {
        return Optional.ofNullable(lottoTickets);
    }
}
