package lotto.domain;

public class LottoCount {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoCount;

    public LottoCount(int purchasedPrice) {
        this.lottoCount = purchasedPrice / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
