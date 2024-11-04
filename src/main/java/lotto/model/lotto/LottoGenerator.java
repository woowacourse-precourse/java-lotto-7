package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.strategy.LottoStrategy;

public class LottoGenerator {

    public List<Lotto> generateLottos(LottoStrategy lottoStrategy, PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoAmount = purchaseAmount.calculatePurchasableLottoAmount();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(lottoStrategy.generateLotto());
        }
        return lottos;
    }

    public Lotto generateSingleLotto(LottoStrategy lottoStrategy) {
        return lottoStrategy.generateLotto();
    }
}
