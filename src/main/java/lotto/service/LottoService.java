package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.NumberGenerate;

public class LottoService {

    private final LottoPurchasedService purchasedService;
    //private final LottoPrizeService prizeService;

    public LottoService(NumberGenerate lottoGenerator) {
        this.purchasedService = new LottoPurchasedService(lottoGenerator);
        //this.prizeService = new LottoPrizeService();
    }

    public List<Lotto> purchaseLotto(int money) {
        return purchasedService.purchaseLotto(money);
    }
}
