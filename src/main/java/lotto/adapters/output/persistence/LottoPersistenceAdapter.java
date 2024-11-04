package lotto.adapters.output.persistence;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.infrastructure.persistence.LottoMemoryRepository;

public class LottoPersistenceAdapter implements LottoRepository {

    private final LottoMemoryRepository lottoMemoryRepository;

    public LottoPersistenceAdapter(LottoMemoryRepository lottoMemoryRepository) {
        this.lottoMemoryRepository = lottoMemoryRepository;
    }

    @Override
    public void save(Lotto lotto) {
        lottoMemoryRepository.save(lotto);
    }

    @Override
    public List<Lotto> findAll() {
        return null;
    }
}
