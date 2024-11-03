package lotto;

import java.util.List;

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
