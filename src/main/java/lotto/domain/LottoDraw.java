package lotto.domain;

import lotto.service.RandomNumbersDraw;

import java.util.List;

public class LottoDraw {
    private final int LOTTO_PRICE = 1000;

    private final int purchasesCount;
    private final List<Lotto> lottoDrawNumbers;

    public LottoDraw(int purchaseAmount) {
        purchasesCount = purchaseAmount / LOTTO_PRICE;
        RandomNumbersDraw randomNumbersDraw = new RandomNumbersDraw();
        lottoDrawNumbers = randomNumbersDraw.randomLottoNumberDraw(purchasesCount);
    }

    public int getPurchasesCount() {
        return purchasesCount;
    }

    public List<Lotto> getLottoDrawNumbers() {
        return lottoDrawNumbers;
    }
}
