package lotto.application.service;

import lotto.domain.generator.LottoNumberGenerator;

public class LottoService {
    private final LottoNumberGenerator numberGenerator;

    public LottoService(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
