package lotto.domain;

public class LottoPrice {
    private static final int LOTTO_UNIT_PRICE = 1000;
    private final int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getCanPurchaseLottoCount() {
        return price / LOTTO_UNIT_PRICE;
    }
}
