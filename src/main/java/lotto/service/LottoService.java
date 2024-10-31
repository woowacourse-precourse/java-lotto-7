package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.NumberGenerate;

public class LottoService {

    private final LottoPurchasedService purchasedService;

    public LottoService(NumberGenerate lottoGenerator) {
        this.purchasedService = new LottoPurchasedService(lottoGenerator);
    }

    public List<Lotto> purchaseLotto(int money) {
        return purchasedService.purchaseLotto(money);
    }
}
