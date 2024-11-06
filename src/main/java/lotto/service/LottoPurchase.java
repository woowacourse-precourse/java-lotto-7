package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoGameConfig;
import lotto.domain.Lotto;

public class LottoPurchase {
    public List<Lotto> purchase(int purchaseAmount) {
        int count = purchaseAmount / LottoGameConfig.PURCHASE_PRICE;
        LottoGenerator LottoGenerator = new LottoGenerator();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }
}
