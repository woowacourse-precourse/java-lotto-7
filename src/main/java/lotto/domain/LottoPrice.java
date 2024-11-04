package lotto.domain;

public enum LottoPrice {
    LOTTO_PRICE(1000);
    private final int price;

    private LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
