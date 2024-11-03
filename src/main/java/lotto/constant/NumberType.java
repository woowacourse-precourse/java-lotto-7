package lotto.constant;

public enum NumberType {
    LOTTO_PRICE(1000);

    private final Integer price;

    NumberType(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
