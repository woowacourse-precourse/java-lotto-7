package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_PRICE;

public class LottoCount {

    private final int lottoCount;

    public LottoCount(int purchasedPrice) {
        this.lottoCount = purchasedPrice / LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
