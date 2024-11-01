package lotto.common.constant;

public enum LottoPrice {

    LOTTO_PRICE(1000);

    private final int price;

    LottoPrice(int price) {
        this.price = price;
    }

    public int price() {
        return price;
    }
}
