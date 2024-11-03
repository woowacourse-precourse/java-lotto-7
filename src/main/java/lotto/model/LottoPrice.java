package lotto.model;

public abstract class LottoPrice {
    protected Integer price;

    LottoPrice() {
        initializePrice();
    }

    public Integer getPrice() {
        return price;
    }

    protected abstract void initializePrice();
}
