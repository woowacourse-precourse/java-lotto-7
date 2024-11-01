package lotto.service;

import lotto.model.LottoNumberGenerator;

public class LottoService {
    private LottoNumberGenerator numberGenerator;

    public LottoService(PolicyService policyService) {
        this.numberGenerator = new LottoNumberGenerator(policyService);
    }
}
