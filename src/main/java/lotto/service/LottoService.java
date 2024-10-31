package lotto.service;

import lotto.domain.Lottos;
import lotto.model.LottoGenerator;

public class LottoService {

    private static final int DIVIDE_STANDARD = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos generateLottos(int money) {
        return lottoGenerator.generateLottos(getLottoCount(money));
    }

    private int getLottoCount(int money) {
        return money / DIVIDE_STANDARD;
    }
}
