package lotto.service;

import lotto.model.LottoFactory;

public class LottoService {
    private final LottoFactory lottoFactory;
    private int lottoCount;

    public LottoService(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

}
