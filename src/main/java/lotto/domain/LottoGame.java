package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottoes;

    public LottoGame(PurchaseAmount purchaseAmount, LottoGenerator lottoGenerator) {
        this.purchaseAmount = purchaseAmount;
        this.lottoes = generateLottoes(lottoGenerator, purchaseAmount.getLottoCount());
    }

    private List<Lotto> generateLottoes(LottoGenerator lottoGenerator, int count) {
        List<Lotto> randomLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomLotto.add(lottoGenerator.generate());
        }
        return randomLotto;
    }

    public int getLottoCount() {
        return purchaseAmount.getLottoCount();
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }
}
