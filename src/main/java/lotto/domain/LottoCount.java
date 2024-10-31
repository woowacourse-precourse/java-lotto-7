package lotto.domain;

public class LottoCount {

    private final static int LOTTO_PRICE = 1000;

    private final int lottoCount;

    private LottoCount(int purchaseAmount) {
        this.lottoCount = getLottoCount(purchaseAmount);
    }

    public static LottoCount from(int purchaseAmount) {
        return new LottoCount(purchaseAmount);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

}