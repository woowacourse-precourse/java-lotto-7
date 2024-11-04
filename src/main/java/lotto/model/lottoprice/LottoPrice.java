package lotto.model.lottoprice;

public class LottoPrice {

    public static final int LOTTO_PRICE = 1000;
    private final int lottoPrice;

    public LottoPrice(String lottoPrice) {
        this.lottoPrice = Integer.parseInt(lottoPrice);
    }

    public int get() {
        return lottoPrice;
    }

    public int getLottoCount() {
        return lottoPrice / LOTTO_PRICE;
    }
}
