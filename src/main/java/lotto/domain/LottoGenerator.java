package lotto.domain;

import lotto.strategy.LottoCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private PurchaseAmount purchaseAmount;
    private List<Lotto> lottos;

    public LottoGenerator(String inputPurchaseAmount, LottoCreateStrategy lottoCreateStrategy) {
        this.purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
        this.lottos = new ArrayList<>();
        generateLottos(lottoCreateStrategy);
    }

    private void generateLottos(LottoCreateStrategy lottoCreateStrategy) {
        int lottoCounts = this.purchaseAmount.findLottoCounts();

        while (lottoCounts > 0) {
            lottos.add(new Lotto(lottoCreateStrategy.createRandomLottoNumbers()));
            lottoCounts--;
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
