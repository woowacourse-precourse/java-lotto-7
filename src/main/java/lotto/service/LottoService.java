package lotto.service;

import lotto.generator.LottoGenerator;
import lotto.model.Lotto;

import java.util.List;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoGenerator.generateLotto(amount);
    }
}