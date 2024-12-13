package lotto.domain;

import lotto.enums.LottoPrize;

import java.util.List;

public class LottoDraw {
    private final int purchasesCount;
    private final List<Lotto> lottoDrawNumbers;

    public LottoDraw(int purchaseAmount, List<Lotto> lottoDrawNumbers) {
        purchasesCount = purchaseAmount / LottoPrize.LOTTO_PRICE_UNIT.getPrize();
        this.lottoDrawNumbers = lottoDrawNumbers;
    }

    public int getPurchasesCount() {
        return purchasesCount;
    }

    public List<Lotto> getLottoDrawNumbers() {
        return lottoDrawNumbers;
    }
}
