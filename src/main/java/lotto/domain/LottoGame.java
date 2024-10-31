package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final PurchaseAmount purchaseAmount;
    private final Lottos lottos;

    public LottoGame(PurchaseAmount purchaseAmount, LottoGenerator lottoGenerator) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = generateLottos(lottoGenerator, purchaseAmount.getLottoCount());
    }

    private Lottos generateLottos(LottoGenerator lottoGenerator, int count) {
        List<Lotto> randomLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomLotto.add(lottoGenerator.generate());
        }
        return new Lottos(randomLotto);
    }

    public int getLottoCount() {
        return purchaseAmount.getLottoCount();
    }

    public String getLottoScreen() {
        return lottos.getLottoNumbersScreen();
    }
}
