package lotto.domain;

import java.util.List;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoGenerator(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lotto issueLotto() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        return new Lotto(lottoNumbers);
    }
}
