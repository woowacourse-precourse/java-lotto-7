package lotto.service;

import lotto.repository.LottoRepositoryImpl;

public class LottoService {

    private final LottoRepositoryImpl lottoRepository;

    public LottoService(LottoRepositoryImpl lottoRepository) {
        this.lottoRepository = lottoRepository;
    }
}
