package lotto.constant;

public enum NumberType {
    LOTTO_PRICE(1000);

    private final long price;

    NumberType(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
