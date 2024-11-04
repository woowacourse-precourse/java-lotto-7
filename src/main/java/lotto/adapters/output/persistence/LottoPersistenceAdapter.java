package lotto.adapters.output.persistence;

import lotto.domain.lotto.repository.LottoRepository;
import lotto.infrastructure.persistence.LottoMemoryRepository;

public class LottoPersistenceAdapter implements LottoRepository {

    private final LottoMemoryRepository lottoMemoryRepository;

    public LottoPersistenceAdapter(LottoMemoryRepository lottoMemoryRepository) {
        this.lottoMemoryRepository = lottoMemoryRepository;
    }
}
