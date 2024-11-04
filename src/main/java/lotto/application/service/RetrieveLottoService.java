package lotto.application.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.application.RetrieveLottoUseCase;
import lotto.domain.repository.LottoRepository;

public class RetrieveLottoService implements RetrieveLottoUseCase {

    private final LottoRepository lottoRepository;

    public RetrieveLottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public List<Lotto> retrieveAll() {
        return lottoRepository.getAll();
    }
}
