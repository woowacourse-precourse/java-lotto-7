package lotto.domain;

import lotto.enums.LottoPrice;

import java.util.List;

public class LottoDraw {
    private final int purchasesCount;
    private final List<Lotto> lottoDrawNumbers;

    public LottoDraw(int purchaseAmount, List<Lotto> lottoDrawNumbers) {
        purchasesCount = purchaseAmount / LottoPrice.LOTTO_PRICE_UNIT.getPrice();
        this.lottoDrawNumbers = lottoDrawNumbers;
    }

    public int getPurchasesCount() {
        return purchasesCount;
    }

    public List<Lotto> getLottoDrawNumbers() {
        return lottoDrawNumbers;
    }
}
