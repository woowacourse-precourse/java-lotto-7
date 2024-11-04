package lotto.infrastructure.repository;

import lotto.domain.model.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl implements LottoRepository {
    private List<LottoTickets> storage = new ArrayList<>();

    @Override
    public void save(LottoTickets lottoTickets) {
        storage.add(lottoTickets);
    }

    @Override
    public LottoTickets findAll() {
        if (storage.isEmpty()) {
            return new LottoTickets(new ArrayList<>());
        }
        return storage.get(storage.size() - 1);
    }

    @Override
    public void clear() {
        storage.clear();
    }

}
