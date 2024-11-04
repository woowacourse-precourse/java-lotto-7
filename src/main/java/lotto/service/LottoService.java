package lotto.service;

import java.util.List;
import lotto.domain.Exchanger;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final Exchanger exchanger;

    public LottoService(LottoGenerator lottoGenerator, Exchanger exchanger) {
        this.lottoGenerator = lottoGenerator;
        this.exchanger = exchanger;
    }

    public List<Lotto> purchaseLotto(Long purchasePrice) {
        return lottoGenerator.purchaseLotto(purchasePrice);
    }
}
