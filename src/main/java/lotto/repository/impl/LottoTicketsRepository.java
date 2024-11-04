package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.LottoTickets;
import lotto.repository.SingleRepository;

public class LottoTicketsRepository implements SingleRepository<LottoTickets> {

    private LottoTickets lottoTickets;

    @Override
    public LottoTickets save(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        return this.lottoTickets;
    }

    @Override
    public Optional<LottoTickets> get() {
        return Optional.ofNullable(lottoTickets);
    }
}
