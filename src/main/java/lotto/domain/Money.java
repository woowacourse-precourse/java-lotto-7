package lotto.domain;

public class Money {
    private static final int DIVISABLE_PRICE = 1000;
    private static final String NOT_DIVISABLE = "[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    int price;
    int amount;

    public Money(int price) {
        validate(price);
        this.price = price;
        this.amount = price / DIVISABLE_PRICE;
    }

    private void validate(int price){
        if (price % DIVISABLE_PRICE != 0){
            throw new IllegalArgumentException(NOT_DIVISABLE);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
