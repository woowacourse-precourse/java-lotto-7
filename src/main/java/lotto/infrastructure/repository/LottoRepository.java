package lotto.infrastructure.repository;

import lotto.domain.model.LottoTickets;

public interface LottoRepository {
    void save(LottoTickets lottoTickets);

    LottoTickets findAll();

    void clear();
}
